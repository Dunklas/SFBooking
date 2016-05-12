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
    FishingSafariStorage fStore = FishingSafariStorageFactory.getStorage();

	public void feasabilityCheck(FishingSafari fs)throws StorageException{
		
		ArrayList<Booking> list = new ArrayList<>();
		list = bStore.get(fs);
		int total = getPaid(list);
		
		if (total >= 5){
			if (fs.getStatus() == 0) {
				fs.setStatus(1);
				fStore.put(fs);
			}

			for(Booking b : list){
				if (b.getBookingStatus() == 1) {
					b.setBookingStatus(2);
					bStore.put(b);
				}
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
			fStore.put(fs);
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
		    if (tempBooking.getBookingStatus() == 0) { //Only change bookings with status "Preliminary"
			    tempBooking.setBookingStatus(1);
			    bStore.put(tempBooking);
		    }

		    // The stuff below runs feasability and final checks for FishingSafari
		    FishingSafari fs = tempBooking.getFishingSafari();
		    feasabilityCheck(fs);
		    finalCheck(fs);
		}
	}
}
