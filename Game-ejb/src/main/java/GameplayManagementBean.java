import gameplay.common.GameplayManagementRemote;
import gameplay.common.PathCalculatorLocal;
import gameplay.common.StatisticCalculatorLocal;
import gameplay.exceptions.NodeNotFoundException;
import gameplay.treeobjects.*;
import java.jms.*;

import javax.ejb.*;
import java.util.List;
@Stateful
public class GameplayManagementBean implements GameplayManagementRemote {
    @EJB
    private PathCalculatorLocal pathCalculator;
    @EJB
    private StatisticCalculatorLocal statisticCalculator;
    StatisticScenarioPath currentPath;
    long userID;
    public GameplayManagementBean(){

    }

    @Inject
    private JMSContext jmsContext;
    @Resource(lookup = "java:global/jms/ObserverTopic")
    private Queue observerQueue;
    @Resource
    private TimerService timerService;

    @Override
    public void startScenario(long scenarioID, long userID) {
       currentPath=new StatisticScenarioPath();
       this.userID=userID;
        try {
           Node currentNode = pathCalculator.getStartNodeOfScenario(scenarioID);
            currentPath.add((currentNode.getID()));
            analyseNode(currentNode);
        } catch (NodeNotFoundException e) {
            e.printStackTrace();
            sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Scenario konnte nicht ausgewählt werden. Bitte kontaktiere Support.",0)));
        }

    }

     @Override
    public void receiveMsgFromClient(long answerID) {
        long lastNode=currentPath.getLastNode();
         try {
             Node currentNode = pathCalculator.getFollowingNode(lastNode,answerID);
             currentPath.add(currentNode.getID());
             analyseNode(currentNode);
         } catch (NodeNotFoundException e) {
             e.printStackTrace();
             sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Antwort konnte nicht verarbeitet werden. Bitte kontaktiere Support.",0)));
         }
    }

    /**
     * Überpüft den Knoten auf Endknoten, speichert den aktuellen Gamepath in der Statistik, und leitet die Nachrichten und Antworten weiter
     * @param currentNode
     */
    private void analyseNode(Node currentNode){
        if(currentNode.isEnd()) {
            statisticCalculator.completeCurrentGamepath(currentPath);
            sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Ende erreicht",0, ""));
        }
        else {
            statisticCalculator.updateCurrentGamepath(currentPath);
            List <NodeMessage> messageList=currentNode.getMessageToClientList();
            for(NodeMessage msg: messageList){
                TimerConfig timerConfig= new TimerConfig();
                timerConfig.setInfo(msg);
                timerConfig.setPersistent(false);
                timerService.createSingleActionTimer((long)messageList.get(i).getTimeout(),timerConfig);

            }
            sendAnswersToClient(currentNode.getAnswerList());
        }
    }

    private void sendMsgToClient(NodeMessage nodeMsg){
        try {
            Message message = jmsContext.createMessage();
            message.setIntProperty("OBSERVER_TYPE",
                    ObserverMessageType.NodeMessage.ordinal());
            jmsContext.createProducer().send(observerQueue, message);
        } catch (JMSException ex) {
            System.err.println("Error while notify observers via
                    queue: " + ex.getMessage());
        }
        //TODO
    }
    private void sendAnswersToClient(List<Answer> pAnswers){
        //TODO
    }

    @Remove
    private void endSession(){

    }
    @Timeout
    public void timeout(Timer timer){
        try {
            NodeMessage msg = (NodeMessage) timer.getInfo();
            sendMsgToClient(msg);
        }catch (Exception e){
           System.err.println("Unecpected Parsing Error. Msg could not be send.");
           System.out.println(e.toString());
        }

    }
}
