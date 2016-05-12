package server.utils.storage;

import java.util.*;

import server.planning.model.*;

public interface SafariDestinationStorage extends ObservableStorage{

	ArrayList<SafariDestination> getList() throws StorageException;
	
	ArrayList<SafariDestination> get(int status) throws StorageException;
	
	SafariDestination get(String location) throws StorageException;
	
	void put(SafariDestination sd) throws StorageException;
}
