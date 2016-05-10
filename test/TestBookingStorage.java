package test;

import server.utils.storage.*;
import server.customer.model.*;
import server.planning.model.*;
import server.booking.model.*;
import java.util.Date;

public class TestBookingStorage {

    private FishingSafariStorage fStore = FishingSafariStorageFactory.getStorage();
    private SafariDestinationStorage sdStore = SafariDestinationStorageFactory.getStorage();
    private BookingStorage bStore = BookingStorageFactory.getStorage();
    private CustomerStorage cStore = CustomerStorageFactory.getStorage();

    public TestBookingStorage() {
	    FishingSafari f1 = fStore.get(21);
	    Customer c1 = null;
	    try {
		    c1 = cStore.get("wille@wille.com");
	    } catch (StorageException ex) {
		    System.out.println(ex.getMessage());
	    }

	    Booking tempBook = new Booking(f1, c1, 1);
	    tempBook.setBooked(new Date());

	    try {
		    bStore.put(tempBook);
	    } catch (StorageException ex) {
		    System.out.println(ex.getMessage());
	    }
    }

    public static void main(String[] args) {
	    new TestBookingStorage();
    }


}
