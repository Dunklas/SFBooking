package server.booking.model;

import java.util.ArrayList;
import java.util.Date;
import server.utils.Insert;
import server.customer.model.Customer;
import server.planning.model.FishingSafari;

public class BookingCatalogue {

    private ArrayList<Booking> bookingList;

    public BookingCatalogue() {
	bookingList = new ArrayList<>();
    }

    public void newBooking(Customer customer, FishingSafari safari) {
    
    Date bookingDate = new Date();

    try {
    Insert dbEntry = new Insert();
    dbEntry.insertBooking(0, 49.50, safari.getId(), customer.getId(), bookingDate);
    }
    catch (Exception x){
    	x.printStackTrace();
    }
    }
}
