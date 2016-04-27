package server.utils.storage;

public interface FishingSafariStorage{

    FishingSafari get();

    FishingSafari get(int status);

    FishingSafari get(int id);

    void put(FishingSafari fs);

}
