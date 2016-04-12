package server.utils;

import java.sql.*;

public class Insert {

    public void insertSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain) throws SQLException {

	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO safaridestination VALUES (?, ?, ?, ?, ?);");
	    stmt.setInt(1, maxParticipants);
	    stmt.setString(2, terrain);
	    stmt.setString(3, equipmentReq);
	    stmt.setString(4, guide);
	    stmt.setString(5, location);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
}
