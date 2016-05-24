package server.utils.storage;

import server.booking.model.*;
import server.customer.model.*;
import server.planning.model.*;
import java.util.*;

public interface BookingStorage extends ObservableStorage{
	
   void put(Booking b) throws StorageException;

   ArrayList<Booking> getByStatus(int status) throws StorageException;

   ArrayList<Booking> getByStatus(int start, int end) throws StorageException; //Range

   Booking get(int id) throws StorageException;

   Booking getLatest() throws StorageException;
   
   ArrayList<Booking> get(Customer c) throws StorageException;

   ArrayList<Booking> get(FishingSafari fs) throws StorageException;


}
