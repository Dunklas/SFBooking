package server.booking.model;

import java.util.Date;

public class FishingSafari{

    private int id; // TO be fixed by db
    private SafariDestination safariDestination;
    private Date startDate;
    private Date endDate;
    
    private boolean minParticipantsMet;
    private boolean maxParticipantsMet;
    private Date announcementDate;
    //bookinglist
    //equipmentlist
    private int nrParticipants;
    private Date timeLimit;
    private boolean assignmentPlanSent;

    public FishingSafari(SafariDestination destination, Date startDate, Date endDate) {
	
    	this.safariDestination = destination;
	    this.startDate = startDate;
	    this.endDate = endDate;
    }
    
    public SafariDestination getSafariDestination(){
	    return safariDestination;
    }
    /*
    public void setAnnouncementDate(Date date) {
	this.announcementDate = date;
	try{
	    OpenDb dbc = new OpenDb();

	} catch
    }
    **/
    public void setEndDate(Date date){
	this.endDate = date;
    }

    public void setMinParticipantsMet(Boolean status){
	this.minParticipantsMet = status;
    }

    public void setMaxParticipantsMet(Boolean status){
	this.maxParticipantsMet = status;
    }

    public void setId(int newId){
	this.id = newId;

    }
    
    public int getId(){
	return id;
    }

    public int getNrParticipants(){
	return nrParticipants;
    }

}//End of class
