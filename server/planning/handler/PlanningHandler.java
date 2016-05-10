package server.planning.handler;

import server.planning.model.FishingSafari;
import server.booking.model.Booking;
import server.utils.storage.*;
import server.planning.model.SafariDestination;
import java.util.ArrayList;

public class PlanningHandler {
   BookingStorage s = BookingStorageFactory.getStorage();

    public int availabilityCheck(FishingSafari fs) throws StorageException {
	SafariDestination sd = fs.getSafariDestination();
	int spotsLeft = 0;
	int booked = 0;
	ArrayList<Booking> bookings = s.get(fs);
	booked = getNrOfParticipants(bookings);
	spotsLeft = sd.getMaxParticipants() - booked;
	return spotsLeft;
    }

    public int getNrOfParticipants(ArrayList<Booking> bookingList){
	int total = 0;
	for (Booking b: bookingList){
	    total = total + b.getNrParticipants();
	}
	System.out.println("Total participants: " + total);
	return total;
    }

}//End of class
