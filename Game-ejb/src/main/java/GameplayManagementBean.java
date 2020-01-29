import gameplay.common.GameplayManagementRemote;
import gameplay.common.PathCalculatorLocal;
import gameplay.common.StatisticCalculatorLocal;
import gameplay.treeobjects.*;

import java.util.List;

public class GameplayManagementBean implements GameplayManagementRemote {
    PathCalculatorLocal pathCalculator;
    StatisticCalculatorLocal statisticCalculator;
    StatisticScenarioPath currentPath;
    long userID;

    @Override
    public void startScenario(long scenarioID, long userID) {
       currentPath=new StatisticScenarioPath();
       this.userID=userID;
       Node currentNode=pathCalculator.getStartNodeOfScenario(scenarioID);
       currentPath.add((currentNode.getID()));
       analyseNode(currentNode);
    }

     @Override
    public void receiveMsgFromClient(long pAnswerID) {
        long lastNode=currentPath.getLastNode();
        Node currentNode=pathCalculator.getFollowingNode(lastNode,pAnswerID);
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
            /*
            for(NodeMessage msg:currentNode.getMessageToClientList()){
                msg.startTimeout();
                sendMsgToClient(msg);
            }*/
            sendAnswersToClient(currentNode.getAnswerList());
        }
    }

    private void sendMsgToClient(NodeMessage msg){

        //TODO
    }
    private void sendAnswersToClient(List<Answer> pAnswers){
        //TODO
    }
}
