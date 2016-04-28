package server.utils.storage;

import server.planning.model.FishingSafari;
import java.util.*;

public interface FishingSafariStorage{

    ArrayList<FishingSafari> get();

    ArrayList<FishingSafari> getByStatus(int status);

    FishingSafari get(int id);

    void put(FishingSafari fs);

}
