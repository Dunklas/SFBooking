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

    public ArrayList<Booking> get(int status) {

	String sql = String.format("SELECT * FROM booking WHERE booking_status = %d", status);
	ResultSet rs = DBHelper.getInstance().query(sql);
	
	return toArrayList(rs);
    }

    public void put(Booking booking) {

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
		System.out.println("From DB-file: " + tempBook);
		bookArrayList.add(tempBook);
	    }
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
	return bookArrayList;
    }
}
