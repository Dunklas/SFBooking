package server.utils.storage;

import server.booking.model.*;
import server.customer.model.*;
import server.planning.model.*;
import java.util.*;

public interface BookingStorage{
	
   void put(Booking b);

   ArrayList<Booking> getByStatus(int status);

   Booking get(int id);

   ArrayList<Booking> get(Customer c);

   ArrayList<Booking> get(FishingSafari fs);


}
