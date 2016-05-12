package server.utils.storage;

import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import java.util.*;

public interface FishingSafariStorage{

    ArrayList<FishingSafari> getList() throws StorageException;

    ArrayList<FishingSafari> getByStatus(int status) throws StorageException;


    FishingSafari get(int id) throws StorageException;

    ArrayList<FishingSafari> getByDestination(SafariDestination destination);

    FishingSafari get(int id) throws StorageException;

    void put(FishingSafari fs) throws StorageException;

}
