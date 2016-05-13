package server.utils.storage;

import server.planning.model.*;
import java.util.*;
import java.sql.*;
import server.utils.storage.StorageException;
import server.utils.logs.Log;

public class FishingSafariStorageDB extends Observable implements FishingSafariStorage{

ArrayList<Observer> observerList = new ArrayList<Observer>();
ArrayList<FishingSafari> updateList = new ArrayList<FishingSafari>();
	
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
    updateList = getList();
    notifyObservers();
  
 
	}

	public ArrayList<FishingSafari> getByStatus(int status) throws StorageException{
    
	    String sql = String.format("SELECT * FROM fishingsafari WHERE status = %d", status);
	    ResultSet rs = DBHelper.getInstance().query(sql);
      
      
	    return DBTranslator.toFishingSafariList(rs);
	}

	public ArrayList<FishingSafari> getByStatus(int start, int end) throws StorageException {

		if (start > end) {
			throw new StorageException("Invalid range. Start status cannot be larger than end status.");
		} else {
			String sql = String.format("SELECT * FROM fishingsafari WHERE status BETWEEN %d AND %d", start, end);
			ResultSet rs = DBHelper.getInstance().query(sql);
			return DBTranslator.toFishingSafariList(rs);
		}
	}

	public FishingSafari get(int id) throws StorageException{
   
		String sql = String.format("SELECT * FROM fishingsafari WHERE safari_id = %d", id);
		ResultSet rs = DBHelper.getInstance().query(sql);
		
		return DBTranslator.toFishingSafari(rs);


	}

  public ArrayList<FishingSafari> getByDestination(SafariDestination destination) throws StorageException{
    
    String destinationString = destination.getLocation();
    String sql = String.format("SELECT * FROM fishingsafari WHERE safaridestination = %s"
      ,destinationString);

    ResultSet rs = DBHelper.getInstance().query(sql);

    return DBTranslator.toFishingSafariList(rs);
  }


	public ArrayList<FishingSafari> getList() throws StorageException{
	    ResultSet rs = DBHelper.getInstance().query("SELECT * FROM fishingsafari");

        return DBTranslator.toFishingSafariList(rs);
	}



    public void addObserver(Observer observer){
      observerList.add(observer);
    }
    public void notifyObservers(){
      for(Observer o : observerList){
        o.update(this,updateList);
      }
    }

	

}
