package server.utils;

import java.sql.*;




public class Update{

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

     public void updateDate(Int id, Date newStartDate, Date newEndDate) throws SQLException {
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




}
