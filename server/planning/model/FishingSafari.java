package server.planning.model;

import java.util.Date;

public class FishingSafari{

    private int id; // TO be fixed by db
    private SafariDestination safariDestination;
    private Date startDate;
    private Date endDate;
    
    private int status; // 0-4 , 0=preliminar,1=utforbar,2=slutgiltig,3=kancellerad,4=genomford
    private Date announcementDate;
    //bookinglist
    //equipmentlist
    
    private Date timeLimit;
    private boolean assignmentPlanSent;

    public FishingSafari(SafariDestination destination, Date startDate, Date endDate,int status) {
	
    	this.safariDestination = destination;
	    this.startDate = startDate;
	    this.endDate = endDate;
        this.status = status;
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

    

    

    public void setId(int newId){
	this.id = newId;

    }
    
    public int getId(){
	return id;
    }

    

}//End of class
