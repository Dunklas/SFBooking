package server.booking.model;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    

    public newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide){
	SafariDestination newSd = new SafariDestination(location, equipmentReq, maxParticipants, guide);
	//Save in list or in db or in both?
    } 

    public changeGuide(String location, String guide){
	
    }

    public changeMaxParticipants(String location, int nr){
	
    }

    public changeEquipmentReq(String location, String text){

    }

    public changeActive(Strng location, boolean active){

    }


}//End of class
