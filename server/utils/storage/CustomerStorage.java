package server.utils.storage;
import server.customer.model.*;

public interface CustomerStorage{


    void put(Customer c);

    Customer get(String email) throws StorageException;
    
    Customer get(int id) throws StorageException;


}
