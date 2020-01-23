package gameplay.common;
import gameplay.treeobjects.StatisticScenarioPath;

@Local
public interface StatisticCalculatorLocal {
    public void updateCurrentGamepath(StatisticScenarioPath path);
    public boolean completeCurrentGamepath(StatisticScenarioPath path);

}
