package server.payment.handler;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import server.booking.model.Booking;
import server.utils.logs.Log;
import server.utils.storage.BookingStorageFactory;
import server.utils.storage.BookingStorage;
import server.utils.storage.StorageException;

public class PaymentHandler {

	BookingStorage bStore = BookingStorageFactory.getStorage();

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
					Log.put(nfe.getMessage()); // Writes faulty text input
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

		}

		// FeasabilityCheck, finalCheck, etc should also be done, but it'll be done in the action listener instead....
	}
}
