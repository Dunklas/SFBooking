package server.planning.model;


import java.util.ArrayList;
import java.util.Scanner;

public class SafariDestination{
    private String location;
    private String equipmentReq;
    private int maxParticipants;
    private String guide;
    private String terrain;
    private int active; //0 = inactive, 1 = active

    public SafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain, int active) {
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
    
    public String getEquipmentReq(){
	return equipmentReq;
    }
    
    public int getMaxParticipants(){
	return maxParticipants;
    }
    
    public String getGuide(){
	return guide;
    }
	
    public String getTerrain(){
		return terrain;
	}

    public int getStatus(){
	return active;
    }
    

    public void setTerrain(String newTerrain){
	this.terrain = newTerrain;
	
    }

    public void setGuide(String newGuide) {
	this.guide = newGuide;
	
    }

    public void setEquipmentReq(String newEquipment){
	this.equipmentReq = newEquipment;
	
    }
   
    public void setMaxParticipants(int newMaxParticipants){
	this.maxParticipants = newMaxParticipants;
	
    }

    public void setStatus(int active){
	this.active = active;
	
    }
    public String toString(){ // can be changed
        return location;
    }
   

    
}//End of class
