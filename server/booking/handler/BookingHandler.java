package server.booking.handler;


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

}
