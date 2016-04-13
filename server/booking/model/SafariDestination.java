package server.booking.model;

import server.utils.Update;

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
	    dbUpdate.updateGuide(this.location, this.equipmentReq);
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
}//End of class
