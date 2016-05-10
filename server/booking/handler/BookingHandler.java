package server.booking.handler;

public class BookingHandler {

	public void paymentCheck() {
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
					//Log an error?
				}
			}
		} catch (FileNotFoundException fnfe) {
			//Do stuff
		}

		for (Integer bookingId : paymentDataList) { // Loops through all bookings from txt-file and set new status and paymentDate
			Booking tempBooking = bStore.get(bookingId);
			tempBooking.setBookingStatus(1);
			tempBooking.setPaymentReceived(new Date()); //Right now
			bStore.put(tempBooking);
		}
	}
}
