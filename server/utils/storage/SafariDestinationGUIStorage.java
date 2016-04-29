package server.utils.storage;

import java.util.*;
import server.planning.model.SafariDestination;

public class SafariDestinationGUIStorage implements SafariDestinationStorage{
  
  ArrayList<SafariDestination> destinations = new ArrayList<SafariDestination>();
  SafariDestination destination;

  SafariDestinationGUIStorage(){
    generateList();
  }
  public void generateList(){
    String [] locations = {"Crystal Lake","Big Horn","Grand Canyon","Victoria Lake","Thunder Bluffs"};
    String [] equipmentReq = {"Machete","Hat","Fishing Rod","Monocle","Spear"};
    String [] guides = {"Jason Vorhees","Freddy Kruger","Michael Myers","Leatherface","Micke Mus"};
    String [] terrain = {"Terr\u00E4ng 1","Terr\u00E4ng 2","Terr\u00E4ng 3"};

    
    for(int i=0; i<locations.length; i++){
      Random rand = new Random();
      int randEquipment = rand.nextInt(4);
      int randParticipants = 10 + rand.nextInt(20);
      int randTerrain = rand.nextInt(3);
      destinations.add(new SafariDestination(locations[i],equipmentReq[randEquipment],randParticipants,guides[i]
        ,terrain[randTerrain],true));
    }
  }
  public ArrayList<SafariDestination> getList(){
    return destinations;
  }
  public ArrayList<SafariDestination> get(int status){
    ArrayList<SafariDestination> statusList = new ArrayList<SafariDestination>();
    for(SafariDestination dest : destinations){
      if(dest.getActive()==true){
        statusList.add(dest);
      }
    }
    return statusList;
  }
  public SafariDestination get(String location){
    
    boolean ok = false;
    while(ok==false){
    for(SafariDestination dest : destinations){
      if(dest.getLocation()==location){
        destination=dest;
        ok=true;
      }
    }
  }
    return destination;

  }

  public void put(SafariDestination sd){
    destinations.add(sd);
  }

}