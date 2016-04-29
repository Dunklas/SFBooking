package server.utils.storage;

public class SafariDestinationStorageFactory {

    public static SafariDestinationStorage getStorage() {
		return new SafariDestinationStorageDB();
    }

    /**
    * Using below storage for testing GUI 
    */
    public static SafariDestinationStorage getGUITestStorage(){
      return new SafariDestinationGUIStorage();
    }
}
