package gameplay.common;
import gameplay.treeobjects.Node;

import javax.ejb.Local;

@Local
public interface PathCalculatorLocal {

    Node getFollowingNode(long lastNode, long answerID);
    Node getNodeWithID(long lastNode);
    Node getStartNodeOfScenario(long scenarioID);
}
