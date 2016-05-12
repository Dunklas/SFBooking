package server.planning.model;

import java.util.Date;
import java.text.DateFormat;

public class FishingSafari{

    private int id; // TO be fixed by db
    private SafariDestination safariDestination;
    private Date startDate;
    private Date endDate;
    
    private int status; // 0-4 , 0=preliminar,1=utforbar,2=slutgiltig,3=kancellerad,4=genomford
    //bookinglist
    //equipmentlist
    
    private Date timeLimit;
    private boolean assignmentPlanSent;
    private DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); // for toString..

    public FishingSafari(SafariDestination destination, Date startDate, Date endDate,int status) {
	
    	this.safariDestination = destination;
	    this.startDate = startDate;
	    this.endDate = endDate;
        this.status = status;
    }
    
    public SafariDestination getSafariDestination(){
	    return safariDestination;
    }

    public void setEndDate(Date date){
	this.endDate = date;
    }

    public Date getEndDate(){
        return endDate;
    }

    public Date getStartDate(){
        return startDate;
    }

    

    

    
    
    public void setId(int newId){
	this.id = newId;

    }
    
    public int getId(){
	return id;
    }

    public int getStatus(){
    return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

public String toString(){
    String stringStartDate = df.format(startDate);
    String stringEndDate = df.format(endDate);
    String stringDestination = safariDestination.getLocation();
    return String.format("%s %s till %s"
        ,stringDestination,stringStartDate,stringEndDate);
}
    

}//End of class
