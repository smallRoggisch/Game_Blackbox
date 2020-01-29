import gameplay.common.GameplayManagementRemote;
import gameplay.common.PathCalculatorLocal;
import gameplay.common.StatisticCalculatorLocal;
import gameplay.treeobjects.*;

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
    /*
    @PostConstruct
    private void init(){

    }
*/
    @Override
    public void startScenario(long scenarioID, long userID) {
       currentPath=new StatisticScenarioPath();
       this.userID=userID;
       Node currentNode=pathCalculator.getStartNodeOfScenario(scenarioID);
       currentPath.add((currentNode.getID()));
       analyseNode(currentNode);
    }

     @Override
    public void receiveMsgFromClient(long answerID) {
        long lastNode=currentPath.getLastNode();
        Node currentNode=pathCalculator.getFollowingNode(lastNode,answerID);
        currentPath.add(currentNode.getID());
        analyseNode(currentNode);
    }

    /**
     * Überpüft den Knoten auf Endknoten, speichert den aktuellen Gamepath in der Statistik, und leitet die Nachrichten und Antworten weiter
     * @param currentNode
     */
    private void analyseNode(Node currentNode){
        if(currentNode.isEnd()) {
            statisticCalculator.completeCurrentGamepath(currentPath);
            sendMsgToClient(new NodeMessage(Messagetype.Text,"Ende erreicht",0, ""));
        }
        else {
            statisticCalculator.updateCurrentGamepath(currentPath);
            List<NodeMessage> messageList=currentNode.getMessageToClientList();
            for(NodeMessage msg: messageList){
               // msg.startTimeout();
                sendMsgToClient(msg);
            }
            sendAnswersToClient(currentNode.getAnswerList());
        }
    }

    private void sendMsgToClient(NodeMessage msg){

        //TODO
    }
    private void sendAnswersToClient(List<Answer> pAnswers){
        //TODO
    }

    @Remove
    private void endSession(){

    }
}
