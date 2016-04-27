package server.utils.storage;

import server.planning.model.FishingSafari;

public class FishingSafariStorageDB implements FishingSafariStorage {

	
	public FishingSafariStorageDB(){
	  
	}

	static void put(FishingSafari fs){

	}

	public FishingSafari getByStatus(int status){

	}

	public FishingSafari get(int id){
		String sql = String.format("SELECT * FROM fishingsafari WHERE id = %d", id);
		ResultSet rs = DBHelper.getInstance().query(sql);
		SafariDestination sd = null;
		FishingSafari fs = null;

		while (rs.next()){
			sd = SafariDestinationStorageFactory.getStorage().get(rs.getString("SafariDestination"));
			fs = new FishingSafari(sd, rs.getDate("START_DATE"), rs.getDate("END_DATE"), rs.getInt("STATUS"));
			fs.setId(rs.getInt("SAFARI_ID");)
        }

        return fs;


	}


	public ArrayList<FishingSafari> get(){
		ArrayList<FishingSafari> fsList = new ArrayList<FishingSafari>();
    	ResultSet rs = DBHelper.getInstance().query("SELECT * FROM fishingsafari");
    	SafariDestination sd = null; 
        FishingSafari fs =null;
    	while (rs.next()){
          sd = SafariDestinationStorageFactory.getStorage().get(rs.getString("SafariDestination"));
          fs = new FishingSafari(sd, rs.getDate("START_DATE"), rs.getDate("END_DATE"), rs.getInt("STATUS"));
          fs.setId(rs.getInt("SAFARI_ID"));
          fsList.add(fs);

    	}

    	return fsList;
	}
	

}