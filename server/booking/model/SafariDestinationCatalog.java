package server.booking.model;

import java.util.*;
import server.utils.Insert;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    

    public void newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain){
	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertSafariDestination(location, equipmentReq, maxParticipants, guide, terrain);
	}
	catch (Exception ex) {
	    System.out.println("Nu blev det problem");
	}
    } 

    public void changeGuide(String location, String guide){
	
    }

    public void changeMaxParticipants(String location, int nr){
	
    }

    public void changeEquipmentReq(String location, String text){

    }

    public void changeActive(String location, boolean active){

    }


}//End of class
