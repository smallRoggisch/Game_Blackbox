import gameplay.common.GameplayManagementRemote;
import gameplay.common.PathCalculatorLocal;
import gameplay.common.StatisticCalculatorLocal;
import gameplay.exceptions.GameHasEndedException;
import gameplay.exceptions.NodeNotFoundException;
import gameplay.exceptions.StatisticNotSavedException;
import gameplay.treeobjects.*;

import javax.annotation.*;
import javax.jms.*;

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

    /**
     *  startet das übergebene Szenario, und führt
     * @param scenarioID Szenarioauswahl (0 oder 1)
     * @param userID ID des Nutzers
     */
    @Override
    public void startScenario(long scenarioID, long userID) {
       currentPath=new StatisticScenarioPath(userID,scenarioID);
       this.userID=userID;
        try {
           Node currentNode = pathCalculator.getStartNodeOfScenario(scenarioID);
            currentPath.add(currentNode);
            analyseNode(currentNode);
        } catch (NodeNotFoundException | GameHasEndedException e) {
            e.printStackTrace();
            sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Scenario konnte nicht ausgewählt werden. Bitte kontaktiere Support.",0,"Server"));
        }

    }

    /**
     * Ermittelt anhand der übergebenen Antwort den nachfolgenden Pfad
     * @param answerID
     */
     @Override
    public void receiveMsgFromClient(long answerID) {
        long lastNode=currentPath.getLastNodeID();
         try {
             Node currentNode = pathCalculator.getFollowingNode(lastNode,answerID);
             currentPath.add(currentNode);
             analyseNode(currentNode);
         } catch (NodeNotFoundException | GameHasEndedException e) {
             e.printStackTrace();
             sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Antwort konnte nicht verarbeitet werden. Bitte kontaktiere Support.",0,"Server")));
         }
    }

    /**
     * Überpüft den Knoten auf Endknoten, speichert den aktuellen Gamepath in der Statistik, und leitet die Nachrichten und Antworten weiter
     * @param currentNode
     */
    private void analyseNode(Node currentNode) throws StatisticNotSavedException {
        if(currentNode.isEnd()) {
            statisticCalculator.completeCurrentGamepath(currentPath);
            sendMsgToClient(new NodeMessage(Messagetype.Servermessage,"Ende erreicht",0, "Server"));
        }
        else {
            //Fehler, der das Spiel nicht weiter beeinträchtigt
            try {
                statisticCalculator.updateCurrentGamepath(currentPath);
            }catch (StatisticNotSavedException e){
                System.out.println(e.getMessage());
            }
            List <NodeMessage> messageList=currentNode.getMessageToClientList();
            for(NodeMessage msg: messageList){
                TimerConfig timerConfig= new TimerConfig();
                timerConfig.setInfo(msg);
                timerConfig.setPersistent(false);
                timerService.createSingleActionTimer((long)messageList.get(i).getTimeout(),timerConfig);
//todo: testen ob timer nacheinander oder gleichzeitig laufen
            }
            sendAnswersToClient(currentNode.getAnswerList());
        }
    }

    /**
     * Sendet eine NodeMsg an den Client
     * @param nodeMsg
     */
    private void sendMsgToClient(NodeMessage nodeMsg){
        try {
            Message message = jmsContext.createMessage();
            message.setIntProperty("OBSERVER_TYPE",
                    ObserverMessageType.NodeMessage);
            //TODO object senden
            jmsContext.createProducer().send(observerQueue, message);
        } catch (JMSException ex) {
            System.err.println("Error while notify observers via
                    queue: " + ex.getMessage());
        }
        //TODO
    }

    /**
     * Sendet die Antwortliste zur Auswahl an den Client
     * @param answerList
     */
    private void sendAnswersToClient(List<Answer> answerList){
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

    @Remove
    private void endSession(){

    }

    /**
     * sendet nach einem timeout die NodeMsg an den Client
     * @param timer
     */
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
