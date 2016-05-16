package server.planning.handler;

import server.planning.model.FishingSafari;
import server.booking.model.Booking;
import server.utils.storage.*;
import server.utils.logs.Log;
import server.planning.model.SafariDestination;
import java.util.ArrayList;

public class PlanningHandler {
   BookingStorage bStore = BookingStorageFactory.getStorage();

    public int availabilityCheck(FishingSafari fs) throws StorageException {
	ArrayList<Booking> bookingList = bStore.get(fs);

	int maxSpots = fs.getSafariDestination().getMaxParticipants();
	int bookedSpots = getNrOfParticipants(bookingList);
	int spotsLeft = maxSpots - bookedSpots;
	
	return spotsLeft;	
    }

    private int getNrOfParticipants(ArrayList<Booking> bookingList){
	int total = 0;
	for (Booking b: bookingList){
	    if (b.getBookingStatus() != 4 && b.getBookingStatus() != 5) {
		total = total + b.getNrParticipants();
	    }
	}
	return total;
    }

    public void printAssignmentPlan(FishingSafari fs) {
	    //List of customers (from related bookings)
	    //Accomondation information
	    //Equipment information
	    //Other...
	    Log.put("Assignment plan sent for FishingSafari: " + fs.getId());
    }

}//End of class
