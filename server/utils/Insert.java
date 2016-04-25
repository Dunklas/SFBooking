package server.utils;

import java.sql.*;
import java.time.*;
import java.util.*;
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
	int status = 0; // This is done because Oracle db does not support booleans
	if (active)
	    status = 1;
	
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO safaridestination VALUES (?, ?, ?, ?, ?, ?)");
	    stmt.setInt(1, maxParticipants);
	    stmt.setString(2, terrain);
	    stmt.setString(3, equipmentReq);
	    stmt.setString(4, guide);
	    stmt.setString(5, location);
	    stmt.setInt(6, status);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }
    /**
     *Insert new Fishing Safari to database
     *<p>
     *@param safariDestination the location of the Fishing Safari
     *@param startDate Date when the Fishing Safari start
     *@param endDate Date when the Fishing Safari ends
     *@return void
     */
    public void insertFishingSafari(String safariDestination, java.util.Date startDate, java.util.Date endDate,int status) throws SQLException {
	Connection c = new OpenDb().getConnection();
	if (c != null) {
	    PreparedStatement stmt = c.prepareStatement("INSERT INTO fishingsafari (safaridestination, end_date, start_date,fishingsafari_status) VALUES (?, ?, ?,?)");
	    stmt.setString(1, safariDestination);
	    stmt.setDate(2, new java.sql.Date(endDate.getTime()));
	    stmt.setDate(3, new java.sql.Date(startDate.getTime()));
            stmt.setInt(4,status);
	    stmt.executeUpdate();

	    stmt.close();
	    c.close();
	}
    }

    public void insertCustomer(String firstName, String lastName, String email, String telephone, java.util.Date registered) throws SQLException { 
    Connection c = new OpenDb().getConnection();
    if (c != null) {
    	PreparedStatement stmt = c.prepareStatement("INSERT INTO customer (first_name, last_name, email, phone_nr, registered) VALUES (?,?,?,?,?)");
    	stmt.setString(1, firstName);
    	stmt.setString(2, lastName);
    	stmt.setString(3, email);
    	stmt.setString(4, telephone);
    	stmt.setDate(5, new java.sql.Date(registered.getTime()));
        stmt.executeUpdate();

        stmt.close();
        c.close();
    }	
    }

    public void insertBooking(int bookingStatus, double price, int safariID, int customerID, java.util.Date booked) throws SQLException {
    Connection c = new OpenDb().getConnection();
    if (c != null) {
    	PreparedStatement stmt = c.prepareStatement("INSERT INTO booking (booking_status, price, safari, customer, booked) VALUES (?,?,?,?,?)");
    	stmt.setInt(1, bookingStatus);
    	stmt.setDouble(2, price);
    	stmt.setInt(3, safariID);
    	stmt.setInt(4, customerID);
    	stmt.setDate(5, new java.sql.Date(booked.getTime()));
    	stmt.executeUpdate();

    	stmt.close();
    	c.close();
    }	
    }
}
