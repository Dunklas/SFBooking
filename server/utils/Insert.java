package server.utils;

import java.sql.*;
import java.time.*;

public class Insert {

    public void insertSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, boolean active) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO safaridestination VALUES (?, ?, ?, ?, ?, ?);");
	    stmt.setInt(1, maxParticipants);
	    stmt.setString(2, terrain);
	    stmt.setString(3, equipmentReq);
	    stmt.setString(4, guide);
	    stmt.setString(5, location);
	    stmt.setBoolean(6, active);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }

    public void insertFishingSafari(String safariDestination, Date startDate, Date endDate) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO fishingsafari (safaridestination, end_date, start_date) VALUES (?, ?, ?);");
	    stmt.setString(1, safariDestination);
	    stmt.setDate(2, endDate);
	    stmt.setDate(3, startDate);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
}
