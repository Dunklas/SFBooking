package server.utils.storage;

public class FishingSafariStorageFactory {

    public static FishingSafariStorage getStorage() {
	return new FishingSafariStorageDB();
    }

    public static FishingSafariStorage getGUITestStorage(){
      return new FishingSafariGUIStorage();
    }
}
