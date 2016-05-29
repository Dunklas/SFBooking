package server.utils.storage;

import server.planning.model.*;
import server.booking.model.*;
import server.customer.model.*;
import server.utils.logs.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTranslator{
  
  static ArrayList<SafariDestination> toSafariDestinationList(ResultSet rs) throws StorageException{

      
      ArrayList<SafariDestination> sdList = new ArrayList<SafariDestination>();
      SafariDestination sd = null;
        try{
        while(rs.next()){
          sd = new SafariDestination (rs.getString("location"), 
                        rs.getString("equipment_req"), 
                        rs.getInt("max_participants"), 
                        rs.getString("guide"), 
                        rs.getString("terrain"), 
                        rs.getInt("active"));
          sdList.add(sd);
        }
        //Log.put("Successfully fetched SafariDestination-list from DB");
    }
    catch(SQLException se){
      throw new StorageException(se);
    }
      return sdList;
    
    }
    
    static SafariDestination toSafariDestination(ResultSet rs) throws StorageException{
      
      SafariDestination sd = null;
        try{
        while(rs.next()){
          sd = new SafariDestination (rs.getString("location"), 
                        rs.getString("equipment_req"), 
                        rs.getInt("max_participants"), 
                        rs.getString("guide"), 
                        rs.getString("terrain"), 
                        rs.getInt("active"));
          
        }
        //Log.put("Successfully fetched SafariDestination from DB");
      }
      catch(SQLException se){
        throw new StorageException(se);
      }
      
      return sd;
    }


   static ArrayList<Booking> toBookingList(ResultSet rs) throws StorageException {
  ArrayList<Booking> bookArrayList = new ArrayList<>();
    try{
          while(rs.next()) {
    
    Booking tempBook = new Booking(FishingSafariStorageFactory.getStorage().get(rs.getInt("safari")),
                 CustomerStorageFactory.getStorage().get(rs.getInt("customer")),
                 rs.getInt("nr_participants"));

    tempBook.setBookingID(rs.getInt("booking_id"));
    tempBook.setBookingStatus(rs.getInt("booking_status"));
    tempBook.setPrice(rs.getDouble("price"));
    tempBook.setBooked(rs.getDate("booked"));
    bookArrayList.add(tempBook);
      }
      //Log.put("Successfully managed to fetch Booking-list from the DB");
      rs.close();
    }
  catch(SQLException se){
    throw new StorageException(se);
  }
  return bookArrayList;
    }

    static Booking toBooking(ResultSet rs) throws StorageException {
  Booking tempBook = null;
    try{
      while(rs.next()) {
    
    tempBook = new Booking(FishingSafariStorageFactory.getStorage().get(rs.getInt("safari")),
               CustomerStorageFactory.getStorage().get(rs.getInt("customer")),
               rs.getInt("nr_participants"));
    tempBook.setBookingID(rs.getInt("booking_id"));
    tempBook.setBookingStatus(rs.getInt("booking_status"));
    tempBook.setPrice(rs.getDouble("price"));
    tempBook.setBooked(rs.getDate("booked"));
      }
      rs.close();
      //Log.put("Successfully managed to fetch Booking from the DB");
  }
  catch(SQLException se){
    throw new StorageException(se);
  }
  return tempBook;
    }

    static ArrayList<FishingSafari> toFishingSafariList(ResultSet rs) throws StorageException{
    ArrayList<FishingSafari> fsList = new ArrayList<FishingSafari>();
    
    SafariDestination sd = null;
    FishingSafari fs = null;
      
      try{
           while (rs.next()){
               sd = SafariDestinationStorageFactory.getStorage().get(rs.getString("SafariDestination"));
               fs = new FishingSafari(sd,
                                      rs.getDate("START_DATE"),
                                      rs.getDate("END_DATE"),
                                      rs.getInt("STATUS"));
               fs.setId(rs.getInt("SAFARI_ID"));
               fsList.add(fs);
           }
     //Log.put("Successfuly fetched FishingSafari-list from the DB");
     rs.close();   
}
catch(SQLException se){
  throw new StorageException(se);
}
    return fsList;

  }

  static FishingSafari toFishingSafari(ResultSet rs)throws StorageException{
    
      SafariDestination sd = null;
      FishingSafari fs = null;

        try{
        while (rs.next()){
               sd = SafariDestinationStorageFactory.getStorage().get(rs.getString("SafariDestination"));
               fs = new FishingSafari(sd,
                                      rs.getDate("START_DATE"),
                                      rs.getDate("END_DATE"),
                                      rs.getInt("STATUS"));
               fs.setId(rs.getInt("SAFARI_ID"));
        }
    //Log.put("Successfully fetched FishingSafari from the DB");
    rs.close();
     }
     catch(SQLException se){
      throw new StorageException(se);
     }
      return fs;

  }

  static Customer toCustomer(ResultSet rs)throws StorageException{
    Customer c = null;
    try{
  while (rs.next()){
      c = new Customer( rs.getString("FIRST_NAME"),
            rs.getString("LAST_NAME"),
            rs.getString("EMAIL"),
            rs.getString("PHONE_NR"),
            rs.getDate("REGISTERED"));

      c.setId(rs.getInt("CUSTOMER_ID"));
  }
  //Log.put("Sucessfully fetched a Customer object from the DB");
}
catch(SQLException se){
  throw new StorageException(se);
}
return c;
}
  
  

    
}
