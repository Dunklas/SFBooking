package server.planning.model;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import server.utils.*;
import javax.swing.*;

public class FishingSafariCatalog{
    
    private List<FishingSafari> safariList = new ArrayList<>();

    public void newFishingSafari(SafariDestination destination, java.util.Date startDate, java.util.Date endDate) {

	String safariDestination = destination.getLocation();

	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertFishingSafari(safariDestination, startDate, endDate,0);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void cancelFishingSafari(int id, boolean active){

    }

    public void changeDate(int id, Date newStartDate, Date newEndDate){

    }

    public ArrayList<String> selectAllFishingSafaris() throws SQLException{
	ArrayList<String> fsList = new ArrayList<String>();
	Select dbEntry = new Select();
	fsList = dbEntry.selectAllFishingSafaris();
	return fsList;
    }




    public FishingSafari selectFishingSafari(int id) throws SQLException{
	Select dbEntry = new Select();
	FishingSafari fs = dbEntry.selectFishingSafari(id);
	return fs;

    }

}
