import server.planning.model.FishingSafari;

package server.utils.storage;

public interface FishingSafariStorage{

    FishingSafari get();

    FishingSafari getByStatus(int status);

    FishingSafari get(int id);

    void put(FishingSafari fs);

}
