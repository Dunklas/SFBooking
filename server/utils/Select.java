package server.utils;

import server.planning.model.*;
import server.customer.model.*;
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
    public ArrayList<String> selectSafariDestinationByStatus(boolean active) throws SQLException{
	int status = 0; // This is done because Oracle DB does not support booleans
	if (active)
	    status = 1;
	
	ArrayList<String> sdList = new ArrayList<String>();
       
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination WHERE active = ?");
	stmt.setInt(1, status);
	ResultSet rs = stmt.executeQuery();

	while (rs.next()){
	    String location =  rs.getString("location");

		sdList.add(location);

	}//End of while

	return sdList;
    }//End of selectSafariDestination


    public ArrayList<String> selectAllSafariDestination() throws SQLException{
	ArrayList<String> sdList = new ArrayList<String>();
	String location = "";
	    Connection c = new OpenDb().getConnection();
	    PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination");
	    ResultSet rs = stmt.executeQuery();
	    
	    while (rs.next()){
		location = rs.getString("location");
		sdList.add(location);

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

   


    public String selectSafariDestinationElement(String location, String column) throws SQLException{
	String element = "";
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination WHERE location = ?");
	//stmt.setString(1, column);
	stmt.setString(1, location);
	ResultSet rs = stmt.executeQuery();

	while (rs.next()){
	    element = rs.getString(column);
	   
	}
	stmt.close();
	c.close();
	return element;
    }

    public ArrayList<String> selectAllFishingSafaris() throws SQLException{
	ArrayList<String> fsList = new ArrayList<String>();
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM fishingsafari");
	ResultSet rs = stmt.executeQuery();
	String tempFs = "";

	while (rs.next()){
	    tempFs = Integer.toString(rs.getInt("safari_id"));
	    tempFs = tempFs +";" +rs.getString("safaridestination");
	    tempFs = tempFs +";" + rs.getDate("start_date");
	    tempFs = tempFs + ";" + rs.getDate("end_date");

	    fsList.add(tempFs);

	}
	return fsList;

    }

    public FishingSafari selectFishingSafari(int id) throws SQLException{
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM fishingsafari where safari_id = ?");
	stmt.setInt(1, id);
	ResultSet rs = stmt.executeQuery();
	String tempLocation = "";
	java.util.Date tempStartDate = new java.util.Date(0);
	java.util.Date tempEndDate = new java.util.Date(0);
	SafariDestination tempsd = new SafariDestination("", "", 0, "", "", true);
	FishingSafari tempFishingSafari = new FishingSafari(tempsd, tempStartDate, tempEndDate, 0); 

	while (rs.next()){
	    tempLocation = rs.getString("safaridestination");
	    SafariDestination tempSd = selectSafariDestination(tempLocation);
	    tempStartDate = rs.getDate("start_date");
	    tempEndDate = rs.getDate("end_date");
	    tempFishingSafari = new FishingSafari(tempSd, tempStartDate, tempEndDate, 0); 

	}
	stmt.close();
	c.close();
	return tempFishingSafari;

    }

    //Returns null if no customer is found
    public Customer selectCustomer(String email) throws SQLException {
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM customer WHERE email = ?");
	stmt.setString(1, email);
	ResultSet rs = stmt.executeQuery();
	Customer queryCustomer = null;

	while (rs.next()) {
	    queryCustomer = new Customer(
	    		    rs.getString("first_name"),
			    rs.getString("last_name"),
			    rs.getString("email"),
			    rs.getString("phone_nr"),
			    new java.util.Date(rs.getDate("registered").getTime()));
	}
	return queryCustomer;
    }

}//End of class
