package server.utils.storage;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import server.booking.model.Booking;
import java.util.*;
import java.sql.*;
import server.utils.logs.Log;

public class BookingStorageDB extends Observable implements BookingStorage {
/*
VI BEHÖVER INTE JÄMFÖRA ATTRIBUT!
KOLLA OM OBJEKT FINNS OCH SKRIV IN RESTEN AV SKITEN
Testa att uppdatera en bokning också...
*/

ArrayList<Observers> observerList = new ArrayList<Observers>();


    public ArrayList<Booking> get(FishingSafari fs) throws StorageException {
	
	String sql = String.format("SELECT * FROM booking WHERE safari = %d", fs.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return DBTranslator.toBookingList(rs);
    }

    public ArrayList<Booking> get(Customer c) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE customer = %d", c.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return DBTranslator.toBookingList(rs);
    }

    public ArrayList<Booking> getByStatus(int status) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE booking_status = %d", status);
	ResultSet rs = DBHelper.getInstance().query(sql);
	
	return DBTranslator.toBookingList(rs);
    }

    public Booking get(int id) throws StorageException {

	String sql = String.format("SELECT * FROM booking WHERE booking_id = %d", id);
	ResultSet rs = DBHelper.getInstance().query(sql);

	return DBTranslator.toBooking(rs);
    }

    public void put(Booking booking) throws StorageException {

	Booking toDb = booking;
	Booking fromDb = get(booking.getBookingID());
	String sql = "";
	
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

    }

    public void addObserver(Observer observer){
      observerList.add(observer);
    }
    public void notifyObservers(){
      for(Observer o : observerList){
        // do something to update view..
      }
    }

    
} // end of class
