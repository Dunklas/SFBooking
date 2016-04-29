package server.utils.storage;

import server.planning.model.*;
import java.util.*;
import java.sql.*;

public class FishingSafariStorageDB implements FishingSafariStorage {

	
	public FishingSafariStorageDB(){
	  
	}

	public void put(FishingSafari fs){

	}

	public ArrayList<FishingSafari> getByStatus(int status){
	    String sql = String.format("SELECT * FROM fishingsafari WHERE status = %d", status);
	    ResultSet rs = DBHelper.getInstance().query(sql);
      
	    return toArrayList(rs);
	}

	public FishingSafari get(int id){
		String sql = String.format("SELECT * FROM fishingsafari WHERE safari_id = %d", id);
		ResultSet rs = DBHelper.getInstance().query(sql);
		
		return toFishingSafari(rs);


	}


	public ArrayList<FishingSafari> getList(){
	    ResultSet rs = DBHelper.getInstance().query("SELECT * FROM fishingsafari");

        return toArrayList(rs);
	}

	private ArrayList<FishingSafari> toArrayList(ResultSet rs){
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
         
		} catch(SQLException ex){
			ex.printStackTrace();
		}

		return fsList;

	}

	private FishingSafari toFishingSafari(ResultSet rs){
		
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
	    } catch(SQLException ex){
	    	ex.printStackTrace();
	    }
	    return fs;

	}
	

}
