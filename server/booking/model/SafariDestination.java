package server.booking.model;

public class SafariDestination{
    private int id; //To be decided by db
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

    // private regChange(){
    // }








}//End of class
