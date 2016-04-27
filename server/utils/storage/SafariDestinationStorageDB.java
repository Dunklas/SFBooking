package server.utils.storage;

import java.util.*;
import java.sql.*;

import server.planning.model.*;

public class SafariDestinationStorageDB implements SafariDestinationStorage{

		SafariDestinationStorageDB(){
			
		}
		public SafariDestination get(){
			
			return null;
		}
		
		public ArrayList<SafariDestination> get(int status){
			
			String sql = String.format("SELECT * safaridestination WHERE active=%d",status);
			ResultSet = rs DBHelper.getInstance().query(sql);
			
			while(rs.hasNext()){
				
			}
			
			return null;
		}
		
		public SafariDestination get(String location){
			
			String sql = String.format("SELECT * FROM safaridestination WHERE location=%s",location);
			ResultSet rs = DBHelper.getInstance().query(sql);
			
			SafariDestination sd = null;
			
			while(rs.hasNext()){
				try{
					sd = new SafariDestination (rs.getString("location"), 
												rs.getString("equipment_req"), 
												rs.getInt("max_participants"), 
												rs.getString("guide"), 
												rs.getString("terrain"), 
												rs.getBoolean("active"));
																 
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			return sd;
		}
		
		public void put(SafariDestination sd){
			
		}
	
}