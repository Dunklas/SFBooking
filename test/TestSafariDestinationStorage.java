package test;

import server.planning.model.*;
import server.utils.storage.*;

public class TestSafariDestinationStorage {

    private SafariDestinationStorage sdStore = SafariDestinationStorageFactory.getStorage();

    public TestSafariDestinationStorage() {
	// Resources
	SafariDestination s1 = new SafariDestination("Lake Bodom", "Shotgun", 14, "Connor MacLeod", "Tundra", true);
	SafariDestination s2 = sdStore.get("Helge ¿¿");

	// Tests

	// put(SafariDestination) - NEW
	sdStore.put(s1);

	// put(SafariDestination) - UPDATE
	s2.setTerrain("Beach");
	sdStore.put(s2);

	// get methods
    }

    public static void main(String[] args) {
	new TestSafariDestinationStorage();
    }
}
