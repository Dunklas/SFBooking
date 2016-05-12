package server.utils.storage;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import server.booking.model.Booking;
import java.util.*;
import java.sql.*;
import server.util.logs.Log;

public class BookingStorageDB implements BookingStorage {
/*
VI BEHÖVER INTE JÄMFÖRA ATTRIBUT!
KOLLA OM OBJEKT FINNS OCH SKRIV IN RESTEN AV SKITEN
Testa att uppdatera en bokning också...
*/
    public ArrayList<Booking> get(FishingSafari fs) throws StorageException {
	
	String sql = String.format("SELECT * FROM booking WHERE safari = %d", fs.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toArrayList(rs);
    }

    public ArrayList<Booking> get(Customer c) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE customer = %d", c.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toArrayList(rs);
    }

    public ArrayList<Booking> getByStatus(int status) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE booking_status = %d", status);
	ResultSet rs = DBHelper.getInstance().query(sql);
	
	return toArrayList(rs);
    }

    public Booking get(int id) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE booking_id = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);

	return toBooking(rs);
    }

    public void put(Booking booking) throws StorageException {

	Booking toDb = booking;
	Booking fromDb = get(booking.getBookingID());
	String sql = "";
	try{
	if (fromDb == null) {
	    sql = "INSERT INTO booking (booking_status, price, safari, customer, booked, nr_participants) VALUES (?, ?, ?, ?, SYSDATE, ?)";
	    DBHelper.getInstance().update(sql,
	    				  new Integer(toDb.getBookingStatus()),
					  new Double(toDb.getPrice()),
					  new Integer(toDb.getFishingSafari().getId()),
					  new Integer(toDb.getCustomer().getId()),
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
	} catch (SQLException ex){
	    throw new StorageException(ex);
	}
    }

    private Booking toBooking(ResultSet rs) throws StorageException {
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
	    Log.put("Successfully managed to fetch Booking from the DB");
	} catch (SQLException ex) {
	    throw new StorageException(ex);
	}
	return tempBook;
    }

    private ArrayList<Booking> toArrayList(ResultSet rs) throws StorageException {
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
	    Log.put("Successfully managed to fetch Bookings from the DB");
	} catch (SQLException ex) {
	    throw new StorageException(ex);
	}
	return bookArrayList;
    }
}
