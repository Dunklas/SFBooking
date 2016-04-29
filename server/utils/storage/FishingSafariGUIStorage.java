package server.utils.storage;

import server.utils.storage.*;
import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import java.util.*;

public class FishingSafariGUIStorage implements FishingSafariStorage{
  ArrayList<FishingSafari> fsList = new ArrayList<FishingSafari>();
  ArrayList<SafariDestination> sdList = new ArrayList<SafariDestination>();

  SafariDestinationStorage storage = SafariDestinationStorageFactory.getGUITestStorage(); //used to fetch destinations

  public FishingSafariGUIStorage(){
    generateList();
  }

  public void generateList(){
    sdList = storage.getList();
    for(SafariDestination sd : sdList){

      fsList.add(new FishingSafari(sd,generateRandomDate(),generateRandomDate(),0));
    }
  }
  public Date generateRandomDate(){
    Random rand = new Random();
    Date randDate;
    long ms = -946771200000L + (Math.abs(rand.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));

    randDate = new Date(ms);
    return randDate;
  } 

  public ArrayList<FishingSafari> getList(){
    return fsList;
  }
  public ArrayList<FishingSafari> getByStatus(int status){
    ArrayList<FishingSafari> statusList = new ArrayList<FishingSafari>();

    for(FishingSafari fs : fsList){
      if(fs.getStatus()==status){
        statusList.add(fs);
      }
    }
    return statusList;
  }
  public FishingSafari get(int id){
    return fs;
  }
  public void put(FishingSafari fs){
    fsList.add(fs);
  }

}