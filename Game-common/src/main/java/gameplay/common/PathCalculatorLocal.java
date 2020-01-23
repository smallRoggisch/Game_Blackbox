package gameplay.common;
import gameplay.treeobjects.Node;

@Local
public interface PathCalculatorLocal {

    Node getFollowingNode(long lastNode, long answerID);
    Node getNodeWithID(long lastNode);
    Node getStartNodeIfScenario(long scenarioID);
}
