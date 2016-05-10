package server.booking.handler;

import server.utils.logs.Log;

public class BookingHandler {

	public void feasabilityCheck(FishingSafari fs){
		ArrayList<Booking> list = new ArrayList<Booking>();
		list = get(fs);

		int total = 0;
		while (i < list.size) {
			if (b.getStatus = 1){
				total = total + b.getNrParticipants();
			  }	

		}
		if (total => 5){
			fs.setStatus(1);
			for(Booking b : list){
				b.setStatus(2);
			}
		}
		}	  

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
		}
	}
}
