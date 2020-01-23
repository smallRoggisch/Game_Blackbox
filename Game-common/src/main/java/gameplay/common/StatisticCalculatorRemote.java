package gameplay.common;

@Remote
public interface StatisticCalculatorRemote {
    public void getStatistics(long userId);
}
