package server.booking.handler;

import server.utils.logs.Log;
import server.planning.model.*;
import server.booking.model.*;
import java.util.ArrayList;
import java.util.Date;
import server.utils.storage.*;

public class BookingHandler {
    BookingStorage bStore = BookingStorageFactory.getStorage();
    FishingSafariStorage fStore = FishingSafariStorageFactory.getStorage();

	public void feasabilityCheck(FishingSafari fs)throws StorageException{
		
		ArrayList<Booking> bookingList = bStore.get(fs);
		int totalPaid = getPaidBookings(list);
		
		if (totalPaid >= 5){
			if (fs.getStatus() == 0) {
				fs.setStatus(1);
				fStore.put(fs);
			}

			for(Booking b : bookingList){
				if (b.getBookingStatus() == 1) {
					b.setBookingStatus(2);
					bStore.put(b);
				}
			}
		}
	}

	public void finalCheck(FishingSafari fs)throws StorageException{

		ArrayList<Booking> bookingList = bStore.get(fs);	
		int totalPaid = getPaidBookings(list);
		int maxSpots = fs.getSafariDestination().getMaxParticipants();	
		if(totalPaid == maxSpots){
			fs.setStatus(2);
			fStore.put(fs);
		} else if(totalPaid > maxSpots){
			Log.put(String.format("FishingSafari overbooked. ID = %d",fs.getId()));
		}
	}
	
	private int getPaidBookings(ArrayList<Booking> bookingList)throws StorageException{
		int total=0;
		for(Booking tempB : bookingList){
			
			if(tempB.getBookingStatus()==1||tempB.getBookingStatus()==2){
				total+=tempB.getNrParticipants();
			}
		}
		return total;
	}

	public void sendPreliminaryConfirmation(Booking b) {
		//Information about booking and payment.
		Log.put("Preliminary confirmation sent for booking: " + b.getBookingID());
	}

	public void sendFinalConfirmation(Booking b) {
		//Information about fishingsafari and booking
		Log.put("Final confirmation sent for booking: " + b.getBookingID());
	}
}
