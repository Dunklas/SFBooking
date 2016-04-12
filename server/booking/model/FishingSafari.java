package server.booking.model;

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

    public void setAnnouncementDate(Date date) {
	this.announcementDate = date;
    }







}//End of class
