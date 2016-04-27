package server.utils.storage;
import server.customer.model.*;

public interface CustomerStorage{


    void put(Customer c);

    Customer get(String email);
    
    Customer get(int id);





}
