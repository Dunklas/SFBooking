package server.utils.storage;

import java.util.*;
import java.sql.*;
import server.utils.storage.StorageException;

import server.planning.model.*;

public class SafariDestinationStorageDB implements SafariDestinationStorage{

		SafariDestinationStorageDB(){
			
		}
		public ArrayList<SafariDestination> getList() throws StorageException{

			ResultSet rs = DBHelper.getInstance().query("SELECT * FROM safaridestination");
			
			return toArrayList(rs);
		}
		
		public ArrayList<SafariDestination> get(int status) throws StorageException{
			
			String sql = String.format("SELECT * safaridestination WHERE active=%d",status);
			ResultSet rs = DBHelper.getInstance().query(sql);
			
			return toArrayList(rs);
		}
		
		public SafariDestination get(String location) throws StorageException{
			
			String sql = String.format("SELECT * FROM safaridestination WHERE location= '%s'",location);
			ResultSet rs = DBHelper.getInstance().query(sql);
			
			return toSafariDestination(rs);
		}
		
		public ArrayList<SafariDestination> toArrayList(ResultSet rs) throws StorageException{
			
			ArrayList<SafariDestination> sdList = new ArrayList<SafariDestination>();
			SafariDestination sd = null;
			try{
				while(rs.next()){
					sd = new SafariDestination (rs.getString("location"), 
												rs.getString("equipment_req"), 
												rs.getInt("max_participants"), 
												rs.getString("guide"), 
												rs.getString("terrain"), 
												rs.getBoolean("active"));
					sdList.add(sd);
				}
				Log.put("Successfully fetched SafariDestination from DB");
			}catch(SQLException e){
			    throw new StorageException(e);
			}
			return sdList;
		}
		
		public SafariDestination toSafariDestination(ResultSet rs){
			
			SafariDestination sd = null;
			try{
				while(rs.next()){
					sd = new SafariDestination (rs.getString("location"), 
												rs.getString("equipment_req"), 
												rs.getInt("max_participants"), 
												rs.getString("guide"), 
												rs.getString("terrain"), 
												rs.getBoolean("active"));
					
				}
				Log.put("Successfully fetched SafariDestination from DB");
			}catch(SQLException e){
			    throw new StorageException(e);
			}
			return sd;
		}
		
		
		public void put(SafariDestination sd){
			
			SafariDestination fromDB = get(sd.getLocation());
			
			if(fromDB == null){	
			String sql = String.format("INSERT INTO SAFARIDESTINATION(MAX_PARTICIPANTS, TERRAIN, EQUIPMENT_REQ, GUIDE, LOCATION, ACTIVE) VALUES (%d,'%s','%s','%s','%s',%d)",sd.getMaxParticipants()
																																										   ,sd.getTerrain()
																																										   ,sd.getEquipmentReq()
																																										   ,sd.getGuide()
																																										   ,sd.getLocation()
																																										   ,1);
			System.out.println(sql);
			
														 
				DBHelper.getInstance().update(sql);
			}else {
				String sql = String.format("UPDATE SAFARIDESTINATION SET MAX_PARTICIPANTS=%d, TERRAIN='%s', EQUIPMENT_REQ='%s', GUIDE='%s', ACTIVE=%d WHERE LOCATION='%s'",sd.getMaxParticipants()
						,sd.getTerrain()
						,sd.getEquipmentReq()
						,sd.getGuide() 
					 	,1
						,sd.getLocation());
				System.out.println(sql);
				DBHelper.getInstance().update(sql);
			}
		}
	
}
