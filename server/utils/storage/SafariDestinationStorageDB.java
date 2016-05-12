package server.utils.storage;

import java.util.*;
import java.sql.*;

import server.utils.storage.StorageException;

import java.util.Observable;
import java.util.Observer;
import server.utils.logs.Log;

import server.planning.model.*;

public class SafariDestinationStorageDB extends Observable implements SafariDestinationStorage {
	
	ArrayList<Observer> observerList = new ArrayList<Observer>();
		SafariDestinationStorageDB(){
			
		}
		
		/**
		*	Observer methods
		*/
		public void addObserver(Observer observer){
			observerList.add(observer);
		}
		protected void setChanged(){

		}
		public void notifyAllObservers() throws StorageException{
			for(Observer o : observerList){
				o.update(this,getList());

			}
		}

		/**
		*	Storage methods
		*/
		public ArrayList<SafariDestination> getList() throws StorageException{

			ResultSet rs = null;
			
			rs = DBHelper.getInstance().query("SELECT * FROM safaridestination");
			
			
			
			return toArrayList(rs);
		}
		
		public ArrayList<SafariDestination> get(int status) throws StorageException{
			ResultSet rs = null;
			
			String sql = String.format("SELECT * safaridestination WHERE active=%d",status);
			rs = DBHelper.getInstance().query(sql);
			
			return toArrayList(rs);
		}
		
		public SafariDestination get(String location) throws StorageException{
			ResultSet rs = null;
			
			String sql = String.format("SELECT * FROM safaridestination WHERE location= '%s'",location);
			rs = DBHelper.getInstance().query(sql);
			
			return toSafariDestination(rs);

		}
				/**
		*	Utils methods
		*/
	
		public ArrayList<SafariDestination> toArrayList(ResultSet rs) throws StorageException{

			
			ArrayList<SafariDestination> sdList = new ArrayList<SafariDestination>();
			SafariDestination sd = null;
			
				while(rs.next()){
					sd = new SafariDestination (rs.getString("location"), 
												rs.getString("equipment_req"), 
												rs.getInt("max_participants"), 
												rs.getString("guide"), 
												rs.getString("terrain"), 
												rs.getInt("active"));
					sdList.add(sd);
				}
				Log.put("Successfully fetched SafariDestination from DB");
		
			return sdList;
		}
		
		public SafariDestination toSafariDestination(ResultSet rs) throws StorageException{
			
			SafariDestination sd = null;
			
				while(rs.next()){
					sd = new SafariDestination (rs.getString("location"), 
												rs.getString("equipment_req"), 
												rs.getInt("max_participants"), 
												rs.getString("guide"), 
												rs.getString("terrain"), 
												rs.getInt("active"));
					
				}
				Log.put("Successfully fetched SafariDestination from DB");
			
			
			return sd;
		}
		
		
		public void put(SafariDestination sd) throws StorageException{
			
		
			SafariDestination fromDB = get(sd.getLocation());
			
			if(fromDB == null){	
			String sql = String.format("INSERT INTO SAFARIDESTINATION(MAX_PARTICIPANTS, TERRAIN, EQUIPMENT_REQ, GUIDE, LOCATION, ACTIVE) VALUES (%d,'%s','%s','%s','%s',%d)",sd.getMaxParticipants()
																																										   ,sd.getTerrain()
																																										   ,sd.getEquipmentReq()
																																										   ,sd.getGuide()
																																										   ,sd.getLocation()
																																										   ,sd.getStatus());
			System.out.println(sql);
			
														 
				DBHelper.getInstance().update(sql);
			}else {
				String sql = String.format("UPDATE SAFARIDESTINATION SET MAX_PARTICIPANTS=%d, TERRAIN='%s', EQUIPMENT_REQ='%s', GUIDE='%s', ACTIVE=%d WHERE LOCATION='%s'",sd.getMaxParticipants()
						,sd.getTerrain()
						,sd.getEquipmentReq()
						,sd.getGuide() 
					 	,sd.getStatus()
						,sd.getLocation());
				System.out.println(sql);
				DBHelper.getInstance().update(sql);
				}

		
		}
	
}
