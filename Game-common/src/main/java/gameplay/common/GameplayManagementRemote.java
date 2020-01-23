package gameplay.common;

@Remote
public interface GameplayManagementRemote {
    
    public void receiveMsgFromClient(long answerID);
    public void startScenario(long scenarioID, long userID);
}
