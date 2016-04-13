package server.booking.model;

import java.util.*;
import server.utils.Insert;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    
    /**
     *Create a new Safari Destination and insert it inot database
     *<p>
     *Use {@link #insertSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, true/false)} to insert into the DB
     *
     *@param location the Location of the Safari Destination
     *@param equipmentReq the required equipment at the Safari Destination
     *@param maxParticipants the number of maximum participants at the Safari Destination
     *@param guide Name of the guide at the Safari Destination
     *@param terrain Terrain at the Safari Destination
     *@return void
     */
    public void newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain){
	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertSafariDestination(location, equipmentReq, maxParticipants, guide, terrain, true);//New Safaridestinations are always active
	}
	catch (Exception ex) {
	    System.out.println(ex.getMessage());
	    System.out.println("Nu blev det problem");
	}
    } 



}//End of class
