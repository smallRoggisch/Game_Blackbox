import gameplay.common.StatisticCalculatorLocal;
import gameplay.common.StatisticCalculatorRemote;
import gameplay.exceptions.StatisticNotSavedException;
import gameplay.treeobjects.StatisticScenarioPath;
//TODO import https://code.google.com/archive/p/json-simple/
import org.json.simple.JSONObject;
import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class StatisticCalculatorBean implements StatisticCalculatorRemote, StatisticCalculatorLocal {
LinkedList<StatisticScenarioPath> gamelist;
    public StatisticCalculatorBean(){
        gamelist=new LinkedList<StatisticScenarioPath>();
    }

//TODO Datenbankanbindung
    public void createNewGamePath(StatisticScenarioPath path)throws StatisticNotSavedException{
        gamelist.addFirst(path);
    }
    public void updateCurrentGamePath(StatisticScenarioPath path) throws StatisticNotSavedException {
        for(StatisticScenarioPath savedPath:gamelist){
            if(savedPath.getGameID()==path.getGameID()){
                gamelist.remove(savedPath);
                gamelist.addFirst(path);
            }
        }
    }

    public void completeCurrentGamePath(StatisticScenarioPath path) throws StatisticNotSavedException {
        for(StatisticScenarioPath savedPath:gamelist){
            if(savedPath.getGameID()==path.getGameID()){
                gamelist.remove(savedPath);
                gamelist.add(path);
            }
        }
        if(!gamelist.contains(path))gamelist.add(path);
    }

    public void getStatistics(long userId) {
        JSONObject statistic= new JSONObject();
        statistic.put("user",userId);
        long playedTime=0; //in Sekunden
        int vistedNodes=0; //nur die maximale anzahl in einem Spiel
        int numberOfGames=0;
        for(StatisticScenarioPath gamePath:gamelist){
            if(gamePath.getUserID()==userId){
                playedTime+=gamePath.getPlayedTime();
                numberOfGames++;
                if(vistedNodes<gamePath.getNumberOfVisitedNodes()){
                    vistedNodes=gamePath.getNumberOfVisitedNodes();
                }
            }
        }
        statistic.put("played-time",playedTime);
        statistic.put("time-unit",'s');
        statistic.put("number-of-games",numberOfGames);
        sendJSONObjectToClient(statistic);
    }
    public void getStatistics() {

    }
    private void sendJSONObjectToClient(JSONObject obj){

    }
    private void sendJSONObjectToAllClient(JSONObject obj){

    }
}
