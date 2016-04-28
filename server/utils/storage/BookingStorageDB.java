package server.utils.storage;

import server.planning.model.FishingSafari;
import server.customer.model.Customer;
import server.booking.model.Booking;
import java.util.*;
import java.sql.*;

public class BookingStorageDB implements BookingStorage {

    BookingStorageDB() {

    }

    public ArrayList<Booking> get(FishingSafari fs) {
	
	String sql = String.format("SELECT * FROM booking WHERE safari = %d", fs.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return null;
    }

    public ArrayList<Booking> get(Customer c) {

	String sql = String.format("SELECT * FROM booking WHERE customer = %d", c.getId());
	ResultSet rs = DBHelper.getInstance().query(sql);

	return null;
    }

    public ArrayList<Booking> get(int status) {

	String sql = String.format("SELECT * FROM booking WHERE booking_status = %d", status);
	ResultSet rs = DBHelper.getInstance().query(sql);
	
	return null;
    }

    public void put(Booking booking) {

    }

    private ArrayList<Booking> toArrayList(ResultSet rs) {
	ArrayList<Booking> bookArrayList = new ArrayList<>();
	try {
	    while(rs.next()) {
		Booking tempBook = new Booking(FishingSafariStorageFactory.getStorage().get(rs.getInt("safari")),
					       CustomerStorageFactory.getStorage().get(rs.getInt("customer")));


	    }
	} catch (SQLException ex) {
	    //..
	}
	return null;
    }
}
