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
	ArrayList<SafariDestination> array = new ArrayList<SafariDestination>();
		SafariDestinationStorageDB(){
			
		}
		
		/**
		*	Observer methods
		*/
		public void addObserver(Observer observer){
			observerList.add(observer);
		}
		
		public void notifyObservers() {
			for(Observer o : observerList){
				o.update(this,array);

			}
		}

		/**
		*	Storage methods
		*/
		public ArrayList<SafariDestination> getList() throws StorageException{

			ResultSet rs = null;
			
			rs = DBHelper.getInstance().query("SELECT * FROM safaridestination");
			ArrayList<SafariDestination> destinationList = DBTranslator.toSafariDestinationList(rs);

						
			return destinationList; 
		}
		
		public ArrayList<SafariDestination> get(int status) throws StorageException{
			ResultSet rs = null;
			
			String sql = String.format("SELECT * safaridestination WHERE active=%d",status);
			rs = DBHelper.getInstance().query(sql);
			ArrayList<SafariDestination> destinationList = DBTranslator.toSafariDestinationList(rs);
			
			
			return destinationList;
		}
		
		public SafariDestination get(String location) throws StorageException{
			ResultSet rs = null;
			
			String sql = String.format("SELECT * FROM safaridestination WHERE location= '%s'",location);
			rs = DBHelper.getInstance().query(sql);
			SafariDestination destination = DBTranslator.toSafariDestination(rs);
			//Should clean.. quick fix
			return destination;

		}
				/**
		*	Utils methods
		*/
	
		
		
		
		public void put(SafariDestination sd) throws StorageException{
			
		
			SafariDestination fromDB = get(sd.getLocation());
			
			if(fromDB == null){	
			String sql = String.format("INSERT INTO SAFARIDESTINATION(MAX_PARTICIPANTS, TERRAIN, EQUIPMENT_REQ, GUIDE, LOCATION, ACTIVE) VALUES (%d,'%s','%s','%s','%s',%d)",sd.getMaxParticipants()
																																										   ,sd.getTerrain()
																																										   ,sd.getEquipmentReq()
																																										   ,sd.getGuide()
																																										   ,sd.getLocation()
																																										   ,sd.getStatus());
			
														 
				DBHelper.getInstance().update(sql);

				
			}else {
				String sql = String.format("UPDATE SAFARIDESTINATION SET MAX_PARTICIPANTS=%d, TERRAIN='%s', EQUIPMENT_REQ='%s', GUIDE='%s', ACTIVE=%d WHERE LOCATION='%s'",sd.getMaxParticipants()
						,sd.getTerrain()
						,sd.getEquipmentReq()
						,sd.getGuide() 
					 	,sd.getStatus()
						,sd.getLocation());
				DBHelper.getInstance().update(sql);


				}
				array = getList();
				notifyObservers();
				

		
		}
	
}
