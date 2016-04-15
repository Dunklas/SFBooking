package server.utils;

import java.sql.*;
/**
 *@author Grupp 11
 *@version 1.1
 *@since 2016-04-12
 */
public class Update{

    /**
     *Update the guide at a Safari destination
     *<p>
     *Use {@see server.utils.Opendb#getConnection()} too open a connection to the database
     *
     *@param location location of the safari destination (used as an identifier)
     *@param newGuide String, the name of the new guide.
     *@return void
     *
     */
    public void updateGuide(String location, String newGuide) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET guide = ? WHERE location = ?");
	    stmt.setString(1, newGuide);
	    stmt.setString(2, location);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
    
    /**
     *Update the equipment required at a safari destination
     *<p>
     *Use {@see server.utils.Opendb#getConnection()} too open a connection to the database
     *
     *@param location String, location of the safari destination (used as an identifier)
     *@param newEquipment String, the name of the new equipment.
     *@return void
     *
     */
    public void updateEquipmentReq(String location, String newEquipment) throws SQLException{
	Connection c = new OpenDb().getConnection();
	if (c != null){
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET equipment_req = ? WHERE location = ?");
	    stmt.setString(1, newEquipment);
	    stmt.setString(2, location);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();

	}

    }
    public void updateStatus(String location, Boolean active) throws SQLException{
	Connection c = new OpenDb().getConnection();
	if (c != null){
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET active = ? WHERE location = ?");
	    stmt.setBoolean(1, active);
	    stmt.setString(2, location);
	    stmt.executeUpdate();
	    stmt.close();
	    c.close();

	}
    }


    public void updateMaxParticipants(String location, int newMaxParticipants) throws SQLException{
	Connection c = new OpenDb().getConnection();
	if (c != null){
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET max_participants = ? WHERE location = ?");
	    stmt.setInt(1, newMaxParticipants);
	    stmt.setString(2, location);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();

	}
    }
    
     public void updateDate(int id, Date newStartDate, Date newEndDate) throws SQLException {
    	Connection c = new OpenDb().getConnection();
    	if (c != null) {
   	    PreparedStatement stmt = c.prepareStatement("UPDATE fishingsafari SET start_date = ?, end_date = ? WHERE safari_id = ?");
    	    stmt.setDate(1, newStartDate);
    	    stmt.setDate(2, newEndDate);
	    stmt.setInt(3, id); 
    	    stmt.executeUpdate();
    	    stmt.close();
    	    c.close();
    	}
     }
    
    public void updateSariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, boolean active) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null){
	    PreparedStatement stmt = c.prepareStatement("UPDATE safaridestination SET equipment_req = ?, max_participants = ?, guide = ?, terrain = ?, active = ? WHERE location = ?"); 
	    stmt.setString(1, equipmentReq);
	    stmt.setInt(2, maxParticipants);
	    stmt.setString(3, guide);
	    stmt.setString(4, terrain);
	    stmt.setBoolean(5, active);
	    stmt.setString(6, location);
	    stmt.executeUpdate();
	    
	    stmt.close();
	    c.close();
	}

    }



    


}
