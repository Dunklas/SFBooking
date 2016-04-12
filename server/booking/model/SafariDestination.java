package server.booking.model;

public class SafariDestination{
    private String location;
    private String equipmentReq;
    private int maxParticipants;
    private String guide;
    private boolean active;

    public SafariDestination(String location, String equipmentReq, int maxParticipants, String guide) {
	this.location = location;
	this.equipmentReq = equipmentReq;
	this.maxParticipants = maxParticipants;
	this.guide = guide;
	this.active = true;
    }



    // private regChange(){
    // }








}//End of class
