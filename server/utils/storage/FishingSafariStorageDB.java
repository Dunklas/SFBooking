package server.utils.storage;

import server.planning.model.*;
import java.util.*;
import java.sql.*;
import server.utils.storage.StorageException;
import server.utils.logs.Log;

public class FishingSafariStorageDB implements FishingSafariStorage {

	
	public FishingSafariStorageDB(){
	  
	}

	public void put(FishingSafari fs) throws StorageException{ 
		FishingSafari fromDb = get(fs.getId());
	
		if(fromDb == null) {
		   String sql = "INSERT INTO fishingsafari (safaridestination, end_date, start_date, status)VALUES(?, ?, ?, ?)";
		   DBHelper.getInstance().update(sql, 
		   				fs.getSafariDestination().getLocation(), 
						fs.getEndDate(), 
						fs.getStartDate(), 
						fs.getStatus());
		} else{
		    String sql = "UPDATE fishingsafari SET safaridestination = ?, end_date = ?, start_date = ?, safari_id = ?, status = ? WHERE safari_id = ?";
		    DBHelper.getInstance().update(sql, 
		    				fs.getSafariDestination().getLocation(), 
						fs.getEndDate(), 
						fs.getStartDate(), 
						fs.getId(), 
						fs.getStatus(), 
						fs.getId()); 
		}
	}

	public ArrayList<FishingSafari> getByStatus(int status) throws StorageException{
	    String sql = String.format("SELECT * FROM fishingsafari WHERE status = %d", status);
	    ResultSet rs = DBHelper.getInstance().query(sql);
      
	    return toArrayList(rs);
	}

	public FishingSafari get(int id) throws StorageException{
		String sql = String.format("SELECT * FROM fishingsafari WHERE safari_id = %d", id);
		ResultSet rs = DBHelper.getInstance().query(sql);
		
		return toFishingSafari(rs);


	}

  public ArrayList<FishingSafari> getByDestination(SafariDestination destination) throws StorageException{
    String destinationString = destination.getLocation();
    String sql = String.format("SELECT * FROM fishingsafari WHERE safaridestination = %s"
      ,destinationString);

    ResultSet rs = DBHelper.getInstance().query(sql);

    return toArrayList(rs);
  }


	public ArrayList<FishingSafari> getList() throws StorageException{
	    ResultSet rs = DBHelper.getInstance().query("SELECT * FROM fishingsafari");

        return toArrayList(rs);
	}

	private ArrayList<FishingSafari> toArrayList(ResultSet rs) throws StorageException{
		ArrayList<FishingSafari> fsList = new ArrayList<FishingSafari>();
		
		SafariDestination sd = null;
		FishingSafari fs = null;
		try {
           while (rs.next()){
               sd = SafariDestinationStorageFactory.getStorage().get(rs.getString("SafariDestination"));
               fs = new FishingSafari(sd,
               	                      rs.getDate("START_DATE"),
               	                      rs.getDate("END_DATE"),
               	                      rs.getInt("STATUS"));
               fs.setId(rs.getInt("SAFARI_ID"));
               fsList.add(fs);
           }
	   Log.put("Successfuly fetched FishingSafaris from the DB");
		} catch(SQLException ex){
		    throw new StorageException(ex);
		}

		return fsList;

	}

	private FishingSafari toFishingSafari(ResultSet rs)throws StorageException{
		
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
		Log.put("Successfully fetched FishingSafari from the DB");
	    } catch(SQLException ex){
	    	throw new StorageException(ex);
	    }
	    return fs;

	}
	

}
