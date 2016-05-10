package server.booking.handler;

import server.utils.logs.Log;
import server.planning.model.*;
import server.booking.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import server.utils.storage.*;
import java.io.FileNotFoundException;

public class BookingHandler {
    BookingStorage bStore = BookingStorageFactory.getStorage();


	public void feasabilityCheck(FishingSafari fs)throws StorageException{
		ArrayList<Booking> list = new ArrayList<Booking>();
		list = bStore.get(fs);

		int total = 0;
		for (Booking b : list) {
		    if (b.getBookingStatus() == 1){
				total = total + b.getNrParticipants();
			  }	

		}
		if (total >= 5){
			fs.setStatus(1);
			for(Booking b : list){
				b.setBookingStatus(2);
			}
		}
	}	  

	public void finalCheck(FishingSafari fs)throws StorageException{
		
		int total = 0;
		ArrayList<Booking> list = new ArrayList<>();
		
		list = bStore.get(fs);
		
		total = getPaid(list);
		
		if(total == fs.getSafariDestination().getMaxParticipants()){
			fs.setStatus(2);
		}else if(total > fs.getSafariDestination().getMaxParticipants()){
			Log.put(String.format("FishingSafari overbooked. ID = %d",fs.getId()));
		}
	}
	
	private int getPaid(ArrayList<Booking> bookingList)throws StorageException{
		int total=0;
		for(Booking tempB : bookingList){
			
			if(tempB.getBookingStatus()==1||tempB.getBookingStatus()==2){
				total+=tempB.getNrParticipants();
			}
		}
		return total;
	}


	public void paymentCheck()throws StorageException {
		Scanner input = null;
		ArrayList<Integer> paymentDataList = new ArrayList<>();
		ArrayList<Booking> paidBookings = new ArrayList<>();
		try { // Fetches all booking IDs from txt-file
			input = new Scanner(new File("payment.txt"));
			while (input.hasNext()) {
				try {
					int bookingId = Integer.parseInt(input.nextLine());
					paymentDataList.add(bookingId);
				} catch (NumberFormatException nfe) {
					Log.put(nfe.getMessage());
				}
			}
		} catch (FileNotFoundException fnfe){
		    Log.put(fnfe.getMessage());
		}

		for (Integer bookingId : paymentDataList) {
		    Booking tempBooking = bStore.get(bookingId);
		    tempBooking.setBookingStatus(1);
		    tempBooking.setPaymentReceived(new Date());
		    bStore.put(tempBooking);
		}
	}
}
