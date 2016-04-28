package server.utils.storage;

public class SafariDestinationStorageFactory {

    public static SafariDestinationStorage getStorage() {
		return new SafariDestinationStorageDB();
    }
}
