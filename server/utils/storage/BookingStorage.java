package server.utils.storage;

import server.booking.model.*;
import server.customer.model.*;
import server.planning.model.*;
import java.util.*;

public interface BookingStorage extends ObservableStorage{
	
   void put(Booking b) throws StorageException;

   ArrayList<Booking> getByStatus(int status) throws StorageException;

   Booking get(int id) throws StorageException;

   ArrayList<Booking> get(Customer c) throws StorageException;

   ArrayList<Booking> get(FishingSafari fs) throws StorageException;


}
