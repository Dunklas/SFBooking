package server.booking.model;

public class SafariDestinationCatalog{
    private List<SafariDestination> safariDestinationList = new ArrayList<>();
    

    public newSafariDestination(String location, String equipmentReq, int maxParticipants, String guide){
	SafariDestination newSd = new SafariDestination(location, equipmentReq, maxParticipants, guide);
	//Save in list or in db or in both?
    } 

    public changeGuide(int id, String guide){
	
    }

    public changeMaxParticipants(int id, int nr){
	
    }

    public changeEquipmentReq(int id, String text){

    }

    public changeActive(int id, boolean active){

    }


}//End of class
