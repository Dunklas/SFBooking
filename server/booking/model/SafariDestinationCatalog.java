package server.booking.model;

import java.util.*;
import server.utils.Insert;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    

    public void newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain){
	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertSafariDestination(location, equipmentReq, maxParticipants, guide, terrain, true);//New Safaridestinations are always active
	}
	catch (Exception ex) {
	    System.out.println("Nu blev det problem");
	}
    } 



}//End of class
