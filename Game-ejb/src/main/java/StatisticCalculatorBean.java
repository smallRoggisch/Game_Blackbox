import gameplay.common.StatisticCalculatorLocal;
import gameplay.common.StatisticCalculatorRemote;
import gameplay.treeobjects.StatisticScenarioPath;

import javax.ejb.Stateless;

@Stateless
public class StatisticCalculatorBean implements StatisticCalculatorRemote, StatisticCalculatorLocal {


    public void updateCurrentGamepath(StatisticScenarioPath path) {

    }


    public boolean completeCurrentGamepath(StatisticScenarioPath path) {
        return false;
    }


    public void getStatistics(long userId) {

    }
}
