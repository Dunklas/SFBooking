package server.utils;

import java.sql.*;
import java.time.*;

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

    public void insertFishingSafari(String safariDestination, Date startDate, Date endDate) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO fishingsafari (safaridestination, endDate, startDate) VALUES (?, ?, ?);");
	    stmt.setString(1, safariDestination);
	    stmt.setDate(2, startDate);
	    stmt.setDate(3, endDate);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
}
