package test;

import server.booking.handler.*;
import server.planning.handler.*;
import server.utils.storage.*;
import server.planning.model.*;

public class TestBookingStatus {

    public TestBookingStatus(){

	    FishingSafariStorage fStore = FishingSafariStorageFactory.getStorage();
	    FishingSafari f1 = fStore.get(21);
	BookingHandler bh = null;
	PlanningHandler ph = null;	
	try{
	bh = new BookingHandler();
	ph = new PlanningHandler();
	bh.paymentCheck();
	System.out.println(ph.availabilityCheck(f1));
	} catch (StorageException se){
	    se.printStackTrace();
	}

	try {
		bh.feasabilityCheck(f1);
		bh.finalCheck(f1);
	} catch(StorageException se) {
		se.printStackTrace();
	}





}
	public static void main(String[] args) {
	    new TestBookingStatus();
	}

	
}
