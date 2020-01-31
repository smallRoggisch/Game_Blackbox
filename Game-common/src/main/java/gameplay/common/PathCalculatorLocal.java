package gameplay.common;
import gameplay.exceptions.NodeNotFoundException;
import gameplay.treeobjects.Node;

import javax.ejb.Local;

@Local
public interface PathCalculatorLocal {

    Node getFollowingNode(long searchNodeID, long answerID) throws NodeNotFoundException;
    Node getNodeWithID(long searchNodeID) throws NodeNotFoundException;
    Node getNodeWithID(long searchNodeID, long scenarioID) throws NodeNotFoundException;
    Node getStartNodeOfScenario(long scenarioID) throws NodeNotFoundException;
}
