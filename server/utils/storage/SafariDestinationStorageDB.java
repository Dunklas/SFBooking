package server.utils.storage;

import java.util.*;
import java.sql.*;

import server.planning.model.*;

public class SafariDestinationStorageDB implements SafariDestinationStorage{

		SafariDestinationStorageDB(){
			
		}
		public ArrayList<SafariDestination> getList(){

			ResultSet rs = DBHelper.getInstance().query("SELECT * FROM safaridestination");
			
			return toArrayList(rs);
		}
		
		public ArrayList<SafariDestination> get(int status){
			
			String sql = String.format("SELECT * safaridestination WHERE active=%d",status);
			ResultSet rs = DBHelper.getInstance().query(sql);
			
			return toArrayList(rs);
		}
		
		public SafariDestination get(String location){
			
			String sql = String.format("SELECT * FROM safaridestination WHERE location= '%s'",location);
			ResultSet rs = DBHelper.getInstance().query(sql);
			
			return toSafariDestination(rs);
		}
		
		public ArrayList<SafariDestination> toArrayList(ResultSet rs){
			
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
			}catch(SQLException e){
					e.printStackTrace();
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
			}catch(SQLException e){
				e.printStackTrace();
			}
			return sd;
		}
		
		
		public void put(SafariDestination sd){
			

			String sql = String.format("INSERT INTO safaridestination VALUES ('%s', '%s', %d, '%s', '%s', 0,)" , sd.getLocation()
																												, sd.getEquipmentReq()
																												, sd.getMaxParticipants()
																												, sd.getGuide()
																												, sd.getTerrain());

			DBHelper.getInstance().update(sql); 
		}
	
}
