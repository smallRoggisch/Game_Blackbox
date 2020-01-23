package gameplay.common;

import javax.ejb.Remote;

@Remote
public interface GameplayManagementRemote {
    
    public void receiveMsgFromClient(long answerID);
    public void startScenario(long scenarioID, long userID);
}
