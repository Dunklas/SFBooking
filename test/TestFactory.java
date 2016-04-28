package test;

import server.customer.model.*;
import server.planning.model.*;
import server.booking.model.*;
import server.utils.storage.*;
import java.util.*;

public class TestFactory {

    CustomerStorage 		cStore = CustomerStorageFactory.getStorage();
    BookingStorage 		bStore = BookingStorageFactory.getStorage();
    SafariDestinationStorage	sStore = SafariDestinationStorageFactory.getStorage();
    FishingSafariStorage 	fStore = FishingSafariStorageFactory.getStorage();

    public static void main(String[] args) {
	new TestFactory();
    }

    public TestFactory() {

	Customer c = cStore.get("wille@wille.com");
	SafariDestination s = sStore.get("Helge ¿¿");
	ArrayList<FishingSafari> f = fStore.get();
	ArrayList<Booking> b = bStore.get(c);

	System.out.println("Customer: " + c + "With ID: " + c.getId());
	
	System.out.println("SafariDestination: " + s);
	
	System.out.println("FishingSafari:");
	for (FishingSafari fs : f) {
	    System.out.println(fs);
	}

	System.out.println("Booking:");
	for (Booking bb : b) {
	    System.out.println(bb);
	}

	java.util.Date dd = new java.util.Date(0); 
	Customer cTemp = new Customer("Palle", "Andersson", "geogoe.com", "oegoeogeo", dd);
	cStore.put(cTemp);
    }
}
