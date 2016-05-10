package server.planning.handler;

import server.planning.model.FishingSafari;
import server.booking.model.Booking;
import server.util.storage.BookingStorageFactory;
import server.planning.model.SafariDestination;
import java.util.ArrayList;

public class PlanningHandler {
    Storage s = BookingStorageFactory.getStorage();

    public int availabilityCheck(FishingSafari fs){
	SafariDestination sd = fs.getSafariDestination();
	int spotsLeft;
	int booked;
	ArrayList<Booking> bookings = s.get(fs);
	booked = getNrOfParticipants(bookings);
	spotsLeft = sd.getMaxParticipants() - booked;
	return spotsLeft;
    }

    public int getNrOfParticipants(ArrayList<Booking> bookingList){
	int total;
	for (booking b: bookingList){
	    total = total + b.getNrParticipants();
	}
	return total;
    }

}//End of class
