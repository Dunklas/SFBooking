package server.util.storage;

public interface SafariDestinationStorage{

	SafariDestination get();
	
	SafariDestination get(int status);
	
	SafariDestination get(int id);
	
	void put(FishingSafari fs);
}