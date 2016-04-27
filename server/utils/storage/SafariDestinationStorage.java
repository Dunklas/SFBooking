package server.utils.storage;

import java.util.*;

import server.planning.model.*;

public interface SafariDestinationStorage{

	SafariDestination get();
	
	ArrayList<SafariDestination> get(int status);
	
	SafariDestination get(String location);
	
	void put(SafariDestination sd);
}