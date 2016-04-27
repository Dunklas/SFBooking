package server.utils.storage;

public class SafariDestinationFactory {

    public static SafariDestionationStorage getStorage() {
		return new SafariDestinationDB();
    }
}