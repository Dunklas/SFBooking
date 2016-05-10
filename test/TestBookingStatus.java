package test;

import server.booking.handler.*;
import server.utils.storage.StorageException;

public class TestBookingStatus {

    public TestBookingStatus(){
	try{
	BookingHandler bh = new BookingHandler();
	bh.paymentCheck();
	} catch (StorageException se){
	    se.printStackTrace();
	}
}
	public static void main(String[] args) {
	    new TestBookingStatus();
	}

	
}
