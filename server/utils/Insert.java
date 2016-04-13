package server.utils;

import java.sql.*;
import java.time.*;
/**
 *@author Grupp 11
 *@version 1.1
 *@since 2016-04-12
 */
public class Insert {
    /**
     *Insert new Safari Destination to database
     *<p>
     *@param location the location of the Safari Destination
     *@param equipmentReq the required equipment for the Safari Destination
     *@param maxParticipants the nr of max participants for the Safari Destination
     *@param guide the name of the guide at the Safari Destination
     *@param terrain the terrain at the Safari Destination
     *@param active the status of the Safari Destination
     *@return void
     */
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
    /**
     *Insert new Fishing Safari to database
     *<p>
     *@param safariDestination the location of the Fishing Safari
     *@param startDate Date when the Fishing Safari starts
     *@param endDate Date when the Fishing Safari ends
     *@return void
     */
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
