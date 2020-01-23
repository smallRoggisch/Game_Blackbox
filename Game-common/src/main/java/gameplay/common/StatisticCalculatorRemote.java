package gameplay.common;

import javax.ejb.Remote;

@Remote
public interface StatisticCalculatorRemote {
    public void getStatistics(long userId);
}
