import gameplay.common.PathCalculatorLocal;
import gameplay.game.ScenarioCreator;
import gameplay.treeobjects.Node;

@Stateless
public class PathCalculatorBean implements PathCalculatorLocal {
    ScenarioCreator scenarioCreator;
    
    @Override
    public Node getFollowingNode(long lastNode, long answerID) {
    //TODO
        return null;
    }

    @Override
    public Node getNodeWithID(long lastNode) {
    //TODO
        return null;
    }

    @Override
    public Node getStartNodeOfScenario(long scenarioID) {
        scenarioCreator=new ScenarioCreator();
        return scenarioCreator.getFirstNode(scenarioID);
    }
}
