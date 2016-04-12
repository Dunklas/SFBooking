package server.booking.model;

import server.utils.Update;

public class SafariDestination{
    private String location;
    private String equipmentReq;
    private int maxParticipants;
    private String guide;
    private String terrain;
    private boolean active;

    public SafariDestination(String location, String equipmentReq, int maxParticipants, String guide, String terrain) {
	this.location = location;
	this.equipmentReq = equipmentReq;
	this.maxParticipants = maxParticipants;
	this.guide = guide;
	this.terrain = terrain;
	this.active = true;
    }

    public String getLocation(){
	return location;

    }

    public void setGuide(String newGuide) {
	this.guide = newGuide;

	Update dbUpdate = new Update();
	dbUpdate.updateGuide(this.location, this.guide);
    }




}//End of class
