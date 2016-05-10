package server.booking.handler;

import server.utils.logs.Log;

public class BookingHandler {

	public void finalCheck(FishingSafari fs){
		
		int total = 0;
		Arraylist<Booking> list = new ArrayList<>();
		
		list = bStore.get(fs);
		
		total = getPaid(list);
		
		if(total = fs.getMaxParticipants()){
			fs.setStatus(2);
		}else if(total > fs.getMaxParticipants()){
			Log.put(String.format("FishingSafari overbooked. ID = %d",fs.getId()));
		}
	}
	
	private int getPaid(ArrayList<Booking> bookingList){
		int total=0;
		for(Booking tempB : bookingList){
			
			if(tempB.getBookingStatus()==1||tempB.getBookingStatus()==2){
				total+=tempB.getNrParticipants();
			}
		}
		return total;
	}


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
					Log.put(nfe.getMessage());
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
