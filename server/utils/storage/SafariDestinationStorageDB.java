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
			
			SafariDestination fromDB = get(sd.getLocation());
			
			if(fromDB == null){	
			String sql = String.format("INSERT INTO SAFARIDESTINATION(MAX_PARTICIPANTS, TERRAIN, EQUIPMENT_REQ, GUIDE, LOCATION, ACTIVE)VALUES (%d,'%s','%s','%s','%s',%d)",sd.getMaxParticipants()
																																										   ,sd.getTerrain()
																																										   ,sd.getEquipmentReq()
																																										   ,sd.getGuide()
																																										   ,sd.getLocation()
																																										   ,1);
			System.out.println(sql);
			
														 
				DBHelper.getInstance().query(sql);
			}else if(fromDB !=null){
				String sql = String.format("UPDATE SAFARIDESTINATION SET MAX_PARTICIPANTS=%d, TERRAIN='%s', EQUIPMENT_REQ='%s', GUIDE='%s', LOCATION='%s', ACTIVE=%d WHERE LOCATION='%s')",sd.getMaxParticipants()
																																														  ,sd.getTerrain()
																																														  ,sd.getEquipmentReq()
																																														  ,sd.getGuide()
																																														  ,sd.getLocation()
																																														  ,1
																																														  ,sd.getLocation());
				DBHelper.getInstance().update(sql);
			}
		}
	
}
