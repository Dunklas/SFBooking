package server.planning.model;

import javax.swing.DefaultListModel;
import java.util.*;
import server.utils.*;
import java.sql.*;

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

    public ArrayList<String> selectAllSafariDestination() throws SQLException{
	ArrayList<String> sdList = new ArrayList<>();
	Select dbEntry = new Select();
	sdList =  dbEntry.selectAllSafariDestination();
	return sdList;

    }

    public ArrayList<String> selectSafariDestinationByStatus(boolean active) throws SQLException {
	ArayList<String> sdList = new ArrayList<String>();
	Select dbEntry = new Select();
	sdList = dbEntry.selectSafariDestinationByStatus(active);
	return sdList;
    }

    public SafariDestination selectSafariDestination(String location) throws SQLException {
	Select dbEntry = new Select();
	SafariDestination tempSd = dbEntry.selectSafariDestination(location);
	return tempSd;

    }

    public ArrayList<String> selectAllGuides() throws SQLException {
	ArrayList<String> sgList = new ArrayList<String>();
	Select dbEntry = new Select();
	sgList = dbEntry.selectAllGuides();
	return sgList;

    }

}//End of class
