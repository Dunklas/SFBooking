package server.utils;

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
     *@param active boolean wich specifies what to Select. Either active or inactive Safari Destinations from the database
     *@return returns the Safari Destinations as an arraylist
     */
    public List selectSafariDestination(boolean active) throws SQLException{
	ArrayList<SafariDestination> sdList = new ArrayList<>();
       
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination WHERE active = ?");
	stmt.setBoolean(1, active);
	ResultSet rs = stmt.executeQuery();

	while (rs.next()){
	    SafariDestination tempSd = new SafariDestination(
							     rs.getString("location");
							     rs.getString("equipment_req");
							     rs.getInt("max_participants");
							     rs.getString("guide");
							     rs.getString("terrain");
							     rs.getBoolean("active");
							     )
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
		sdList.add(location);

	    }
	return sdList;

    }



}//End of class
