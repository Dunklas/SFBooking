package server.utils.storage;

public interface CustomerStorage{


    void put(Customer c);

    Customer get(String email);
    
    Customer get(int id);





}
