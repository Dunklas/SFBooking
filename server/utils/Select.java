package server.utils;

import server.booking.model.*;
import javax.swing.DefaultListModel;
import java.util.*;
import java.sql.*;
/**
 *@author Grupp 11
 *@version 1.1
 *@since 2016-04-12
 */

public class Select {

    /**
     *Populate an arraylist with either active or inactive Safari Destinations
     *<p>
     *@param active Boolean wich specifies what to Select. Either active or inactive Safari Destinations from the database
     *@return returns the Safari Destinations as an arraylist
     */
    public List selectSafariDestinationByStatus(boolean active) throws SQLException{
	ArrayList<SafariDestination> sdList = new ArrayList<>();
       
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination WHERE active = ?");
	stmt.setBoolean(1, active);
	ResultSet rs = stmt.executeQuery();

	while (rs.next()){
	    String location =  rs.getString("location");
	    String equipment_req = rs.getString("equipment_req");
 	    int max_participants = rs.getInt("max_participants");
	    String guide = rs.getString("guide");
	    String terrain = rs.getString("terrain");
	    Boolean tempActive =  rs.getBoolean("active");

	    SafariDestination tempSd = new SafariDestination(location, equipment_req, max_participants, guide, terrain, tempActive);
		sdList.add(tempSd);
	}//End of while

	return sdList;
    }//End of selectSafariDestination


    public DefaultListModel<String> selectAllSafariDestination() throws SQLException{
	DefaultListModel<String> sdList = new DefaultListModel<>();
	String location = "";
	    Connection c = new OpenDb().getConnection();
	    PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination");
	    ResultSet rs = stmt.executeQuery();
	    
	    while (rs.next()){
		location = rs.getString("location");
		sdList.addElement(location);

	    }
	return sdList;

    }

    public ArrayList<String> selectAllGuides() throws SQLException{
	ArrayList<String> sdList = new ArrayList<>();
	String guide = "";
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT DISTINCT guide FROM safaridestination");
	ResultSet rs = stmt.executeQuery();

	while (rs.next()){
	    guide = rs.getString("guide");
	    sdList.add(guide);
    }
	return sdList;
    }
    public SafariDestination selectSafariDestination(String location) throws SQLException{
	Connection c = new OpenDb().getConnection();
	
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination WHERE location = ?");
	stmt.setString(1, location);
	ResultSet rs = stmt.executeQuery();
	String tempLocation = ""; String equipment_req = ""; int max_participants = -1; String guide = ""; String terrain = ""; Boolean active = true;

	while (rs.next()){
	    tempLocation =  rs.getString("location");
	    equipment_req = rs.getString("equipment_req");
 	    max_participants  = rs.getInt("max_participants");
	    guide  = rs.getString("guide");
	    terrain = rs.getString("terrain");
	    active =  rs.getBoolean("active");

	  
	}
	SafariDestination tempSd = new SafariDestination(tempLocation, equipment_req, max_participants, guide, terrain, active);
	stmt.close();
	c.close();
	return tempSd;
	
	}


}//End of class
