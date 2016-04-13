package server.utils;

import java.util.*;
import java.sql.*;


public class Select {



    public List selectSafariDestination(boolean active){
	ArrayList<SafariDestination> sdList = new ArrayList<>();
	try{
	Connection c = new OpenDb().getConnection();
	PreparedStatement stmt = c.prepareStatement("SELECT * FROM safaridestination where active = ?");
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
	} catch (Exception ex){
	    
	}
	return sdList;
    }//End of selectSafariDestination






}//End of class
