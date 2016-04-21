package server.planning.model;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import server.utils.*;
import javax.swing.*;

public class FishingSafariCatalog{
    
    private List<FishingSafari> safariList = new ArrayList<>();

    public void newFishingSafari(SafariDestination destination, java.sql.Date startDate, java.sql.Date endDate) {

	String safariDestination = destination.getLocation();

	try {
	    Insert dbEntry = new Insert();
	    dbEntry.insertFishingSafari(safariDestination, startDate, endDate);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    public void cancelFishingSafari(int id, boolean active){

    }

    public void changeDate(int id, Date newStartDate, Date newEndDate){

    }

    public DefaultListModel<String> selectAllFishingSafaris() throws SQLException{
	DefaultListModel<String> fsList = new DefaultListModel<String>();
	Select dbEntry = new Select();
	fsList = dbEntry.selectAllFishingSafaris();
	return fsList;
    }






}
