package server.planning.model;

import java.sql.*;
import server.utils.Update;
import server.utils.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SafariDestination{
    private String location;
    private String equipmentReq;
    private int maxParticipants;
    private String guide;
    private String terrain;
    private boolean active;

    public SafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, boolean active) {
	this.location = location;
	this.equipmentReq = equipmentReq;
	this.maxParticipants = maxParticipants;
	this.guide = guide;
	this.terrain = terrain;
	this.active = active;
    }

    public String getLocation(){
	return location;

    }
    
    public ArrayList<String> getEquipmentReq(){
  ArrayList<String> parsedEquipment = new ArrayList<String>();
  Scanner parser = new Scanner(this.equipmentReq).useDelimiter(";");
  while(parser.hasNext()){
    parsedEquipment.add(parser.next());
  }
  return parsedEquipment;    
    }
    
    public int getMaxParticipants(){
	return maxParticipants;
    }
    
    public String getGuide(){
	return guide;
    }

    public ArrayList<String> getTerrain(){
	ArrayList<String> parsedTerrain = new ArrayList<String>();
  Scanner parser = new Scanner(this.terrain).useDelimiter(";");
  while(parser.hasNext()){
    parsedTerrain.add(parser.next());
  }
  return parsedTerrain;    
    }
    

    public boolean getActive(){
	return active;
    }
    

    public void setTerrain(String newTerrain){
	this.terrain = newTerrain;
	try{
	    Update dbUpdate = new Update();
	    dbUpdate.updateTerrain(this.location, this.terrain);
	} catch (Exception ex){
	    ex.printStackTrace();
	}
    }

    public void setGuide(String newGuide) {
	this.guide = newGuide;
	try{
	Update dbUpdate = new Update();
	dbUpdate.updateGuide(this.location, this.guide);
	} catch (Exception ex){
	    ex.printStackTrace();
	}
    }

    public void setEquipmentReq(String newEquipment){
	this.equipmentReq = newEquipment;
	try{
	    Update dbUpdate = new Update();
	    dbUpdate.updateEquipmentReq(this.location, this.equipmentReq);
	} catch (Exception ex){
	    ex.printStackTrace();
	}
    }
   
    public void setMaxParticipants(int newMaxParticipants){
	this.maxParticipants = newMaxParticipants;
	try{
	    Update dbUpdate = new Update();
	    dbUpdate.updateMaxParticipants(this.location, this.maxParticipants);
	} catch (Exception ex){
	    ex.printStackTrace();
	}
    }

    public void setStatus(Boolean active){
	this.active = active;
	try{
	    Update dbUpdate = new Update();
	    dbUpdate.updateStatus(this.location, this.active);
	} catch (Exception ex){
	    ex.printStackTrace();
	}
    }
    /**
    public void updateSafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, boolean active) throws SQLException{
	Update dbUpdate = new Update();
	dbUpdate.updateSafariDestination(location, equipmentReq, maxParticipants, guide, terrain, active);
	System.out.println("Kom in i metodanrop i safari destination modellen");
    }
    */

    public String getSafariDestinationElement(String location, String column) throws SQLException{
	Select dbSelect = new Select();
	String element = dbSelect.selectSafariDestinationElement(location, column);
	return element;

    }

}//End of class
