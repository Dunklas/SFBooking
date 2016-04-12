package server.booking.model;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    

    public newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide){
	SafariDestination newSd = new SafariDestination(location, equipmentReq, maxParticipants, guide);
	//Save in list or in db or in both?
    } 

    public changeGuide(int id){
	
    }

    public changeMaxParticipants(int id, int nr){
	
    }




}//End of class
