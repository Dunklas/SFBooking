package server.utils.storage;

public class FishingSafariStorageFactory {

    public static FishingSafariStorage getStorage() {
	return new FishingSafariStorageDB();
    }
}
