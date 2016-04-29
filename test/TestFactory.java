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
	ArrayList<FishingSafari> f = fStore.getList();
	FishingSafari fishingsafari = null;

	for (FishingSafari fs : f) {
	    fishingsafari = fs;
	}

	//Booking bookTest = new Booking(fishingsafari, c, 2);
	//bookTest.setBooked(new Date());

	Booking b1 = bStore.get(22);
	b1.setBookingStatus(2);
	b1.setPrice(400.57);
	b1.setBooked(new java.util.Date());

	bStore.put(b1);
/*
	System.out.println("Customer: " + c + "With ID: " + c.getId());
	
	System.out.println("SafariDestination: " + s);
	
	System.out.println("FishingSafari:");
	for (FishingSafari fs : f) {
	    System.out.println(fs);
	    fishingsafari = fs;
	}

	ArrayList<Booking> b = bStore.get(0);

	System.out.println("Booking:");
	for (Booking bb : b) {
	    System.out.println(bb);
	}

	java.util.Date dd = new java.util.Date(0); 
	Customer cTemp = new Customer("Palle", "Andersson", "geogoe.com", "oegoeogeo", dd);
	cStore.put(cTemp);
	*/
    }
}
