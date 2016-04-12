package server.booking.model;

import java.util.*;
import java.sql.Date;
import server.utils.Insert;

public class FishingSafariCatalog{
    
    private List<FishingSafari> safariList = new ArrayList<>();

    public void newFishingSafari(SafariDestination destination, java.sql.Date startDate, java.sql.Date endDate) {

	String safariDestination = destination.getLocation();

	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertFishingSafari(safariDestination, startDate, endDate);
	} catch (Exception ex) {
	    System.out.println("Nu blev det fel");
	}
    }

    public void cancelFishingSafari(int id, boolean active){

    }

    public void changeDate(int id, Date newStartDate, Date newEndDate){

    }








}
