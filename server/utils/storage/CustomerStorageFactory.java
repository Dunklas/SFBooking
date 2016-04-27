package server.utils.storage;

public class CustomerStorageFactory{

    public static CustomerStorage getStorage(){
	return new CustomerStorageDB();

    }





}
