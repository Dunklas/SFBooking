package server.booking.model;

import java.sql.*;
import server.utils.Update;
import server.utils.*;

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

    public Boolean getActive(){
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
	System.out.println("Safaridestination modellen");
	return element;

    }

}//End of class
