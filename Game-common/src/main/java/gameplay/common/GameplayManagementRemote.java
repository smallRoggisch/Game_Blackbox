package gameplay.common;

public interface GameplayManagementRemote {
    public void receiveMsgFromClient(String pMsg);
    public void receiveMsgFromClient(long pID);
}
