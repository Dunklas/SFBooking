package server.utils.storage;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import server.booking.model.Booking;
import java.util.*;
import java.sql.*;

public class BookingStorageDB implements BookingStorage {
/*
VI BEHÖVER INTE JÄMFÖRA ATTRIBUT!
KOLLA OM OBJEKT FINNS OCH SKRIV IN RESTEN AV SKITEN
Testa att uppdatera en bokning också...
*/
    public ArrayList<Booking> get(FishingSafari fs) {
	
	String sql = String.format("SELECT * FROM booking WHERE safari = %d", fs.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toArrayList(rs);
    }

    public ArrayList<Booking> get(Customer c) {

	String sql = String.format("SELECT * FROM booking WHERE customer = %d", c.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toArrayList(rs);
    }

    public ArrayList<Booking> getByStatus(int status) {

	String sql = String.format("SELECT * FROM booking WHERE booking_status = %d", status);
	ResultSet rs = DBHelper.getInstance().query(sql);
	
	return toArrayList(rs);
    }

    public Booking get(int id) {

	String sql = String.format("SELECT * FROM booking WHERE booking_id = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toBooking(rs);
    }

    public void put(Booking booking) {

	Booking toDb = booking;
	Booking fromDb = get(booking.getBookingID());
	String sql = "";

	if (fromDb == null) {
	    sql = "INSERT INTO booking (booking_status, price, safari, customer, booked, nr_participants) VALUES (?, ?, ?, ?, ?, ?)";
	    DBHelper.getInstance().update(sql,
	    				  new Integer(toDb.getBookingStatus()),
					  new Double(toDb.getPrice()),
					  new Integer(toDb.getFishingSafari().getId()),
					  new Integer(toDb.getCustomer().getId()),
					  toDb.getBooked(),
					  new Integer(toDb.getNrParticipants()));
	    System.out.println(sql);
	}
	else {
	    sql = "UPDATE booking SET booking_status = ?, price = ?, safari = ?, customer = ?, booked = ?, nr_participants = ? WHERE booking_id = ?";
	    DBHelper.getInstance().update(sql,
	    				  new Integer(toDb.getBookingStatus()),
					  new Double(toDb.getPrice()),
					  new Integer(toDb.getFishingSafari().getId()),
					  new Integer(toDb.getCustomer().getId()),
					  toDb.getBooked(),
					  new Integer(toDb.getNrParticipants()),
					  new Integer(toDb.getBookingID()));
	}
    }

    private Booking toBooking(ResultSet rs) {
	Booking tempBook = null;
	try {
	    while(rs.next()) {
		tempBook = new Booking(FishingSafariStorageFactory.getStorage().get(rs.getInt("safari")),
				       CustomerStorageFactory.getStorage().get(rs.getInt("customer")),
				       rs.getInt("nr_participants"));
		tempBook.setBookingID(rs.getInt("booking_id"));
		tempBook.setBookingStatus(rs.getInt("booking_status"));
		tempBook.setPrice(rs.getDouble("price"));
		tempBook.setBooked(rs.getDate("booked"));
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
	return tempBook;
    }

    private ArrayList<Booking> toArrayList(ResultSet rs) {
	ArrayList<Booking> bookArrayList = new ArrayList<>();
	try {
	    while(rs.next()) {
		Booking tempBook = new Booking(FishingSafariStorageFactory.getStorage().get(rs.getInt("safari")),
					       CustomerStorageFactory.getStorage().get(rs.getInt("customer")),
					       rs.getInt("nr_participants"));

		tempBook.setBookingID(rs.getInt("booking_id"));
		tempBook.setBookingStatus(rs.getInt("booking_status"));
		tempBook.setPrice(rs.getDouble("price"));
		tempBook.setBooked(rs.getDate("booked"));
		bookArrayList.add(tempBook);
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
	return bookArrayList;
    }
}
