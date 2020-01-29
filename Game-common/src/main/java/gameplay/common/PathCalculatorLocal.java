package gameplay.common;
import gameplay.treeobjects.Node;

import javax.ejb.Local;

@Local
public interface PathCalculatorLocal {

    Node getFollowingNode(long searchNodeID, long answerID);
    Node getNodeWithID(long searchNodeID);
    Node getNodeWithID(long searchNodeID, long scenarioID);
    Node getStartNodeOfScenario(long scenarioID);
}
