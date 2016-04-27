package server.utils.storage;

public interface BookingStorage{
	
   void put(Booking b);

   Booking get(int status);

   Booking get(Customer c);

   Booking get (FishingSafari fs);


}