package server.utils.storage;

import server.planning.model.FishingSafari;
import server.planning.model.SafariDestination;
import java.util.*;

public interface FishingSafariStorage{

    ArrayList<FishingSafari> getList();

    ArrayList<FishingSafari> getByStatus(int status);

    ArrayList<FishingSafari> getByDestination(SafariDestination destination);

    FishingSafari get(int id);

    void put(FishingSafari fs);

}
