package server.utils.storage;

public class SafariDestinationFactory {

    public static SafariDestionationFactory getStorage() {
		return new SafariDestinationDB();
    }
}