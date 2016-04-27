package server.utils.storage;

public class BookingStorageFactory {

    public static BookingStorage getStorage() {
	return new BookingStorageDB();
    }
}
