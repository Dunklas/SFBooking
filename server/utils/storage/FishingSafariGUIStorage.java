package server.utils.storage;

import server.utils.storage.SafariDestinationStorage;
import server.utils.storage.SafariDestinationStorageFactory;
import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import java.util.*;

public class FishingSafariGUIStorage {
  ArrayList<FishingSafari> fsList = new ArrayList<FishingSafari>();
  ArrayList<SafariDestination> sdList = new ArrayList<SafariDestination>();

  //FishingSafari fs = new FishingSafari(,new Date(),new Date(),0);
  SafariDestinationStorage storage = SafariDestinationStorageFactory.getGUITestStorage(); //used to fetch destinations

  public FishingSafariGUIStorage(){
    try{
      generateList();
    }
    catch(StorageException se){
      //...
    }
  }

  public void generateList() throws StorageException{
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
    //return fs;
    return null;
  }
  public void put(FishingSafari fs){
    fsList.add(fs);
  }

  public ArrayList<FishingSafari> getByDestination(SafariDestination destination){
    return null;
  }

  public void addObserver(Observer observer){

  }
  public void notifyObservers(){
    
  }

}
