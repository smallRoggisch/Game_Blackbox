package gameplay.common;
import gameplay.exceptions.StatisticNotSavedException;
import gameplay.treeobjects.StatisticScenarioPath;

import javax.ejb.Local;

@Local
public interface StatisticCalculatorLocal {
    public void createNewGamePath(StatisticScenarioPath path) throws StatisticNotSavedException;
    public void updateCurrentGamePath(StatisticScenarioPath path)throws  StatisticNotSavedException;
    public void completeCurrentGamePath(StatisticScenarioPath path) throws StatisticNotSavedException;

}
