package server.utils.storage;

public interface CustomerStorage{


    void put();

    Customer get(String email);
    
    Customer get(int id);





}
