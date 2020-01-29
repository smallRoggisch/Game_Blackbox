import gameplay.common.PathCalculatorLocal;
import gameplay.game.ScenarioCreator;
import gameplay.treeobjects.Answer;
import gameplay.treeobjects.Node;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PathCalculatorBean implements PathCalculatorLocal {
    ScenarioCreator scenarioCreator;
    Node firstNodes[];

    public PathCalculatorBean(){
        firstNodes[0]=scenarioCreator.getFirstNode(0);
        firstNodes[1]= scenarioCreator.getFirstNode(1);
    }
/*
   @PostConstruct
   private void init(){

   }
*/
    @Override
    public Node getFollowingNode( long lastNodeID, long answerID) {
    Node lastNode=getNodeWithID(lastNodeID);
    List<Answer> answers=lastNode.getAnswerList();
    for(Answer i:answers){
        if(i.getAnswerID() == answerID){
            return i.getAnswerNode();
        }
    }
    System.out.println("Wrong ID in PathCalculatorBean.getFollowingNode(lastNodeID: "+lastNodeID+", answerID: "+answerID);
    return  null;
    }

    @Override
    public Node getNodeWithID(long searchNodeID) {
        Node searchScenario0=searchChilrden(firstNodes[0], searchNodeID);
        if(searchScenario0!=null) return searchScenario0;
       return searchChilrden(firstNodes[1],searchNodeID);

    }
    public Node getNodeWithID(long searchNodeID,long scenarioID) {
        return searchChilrden(firstNodes[(int) scenarioID],searchNodeID);
    }
    private Node searchChilrden(Node parentNode, long searchNodeID){
       List<Answer> answers=parentNode.getAnswerList();
        for (Answer i: answers) {
            if(i.getAnswerNode().getID().equals(searchNodeID)) {
                return i.getAnswerNode();
            }
            if(!i.getAnswerNode().isEnd()){
                Node searchNode=searchChilrden(i.getAnswerNode(),searchNodeID);
                if(searchNode!=null)return searchNode;
            }
        }
        return null;
    }

    @Override
    public Node getStartNodeOfScenario(long scenarioID) {
        scenarioCreator=new ScenarioCreator();
        return scenarioCreator.getFirstNode(scenarioID);
    }
}
