package test;

import server.utils.storage.*;
import server.planning.model.*;
import java.util.Date;

public class TestFishingSafariStorage {

    private FishingSafariStorage fStore = FishingSafariStorageFactory.getStorage();
    private SafariDestinationStorage sdStore = SafariDestinationStorageFactory.getStorage();

    public TestFishingSafariStorage() {
	//Resources
	SafariDestination s1 = sdStore.get("Helge ¿¿"); // Existing SafariDestination
	FishingSafari f1 = new FishingSafari(s1, new Date(), new Date(), 0); // New FishingSafari
	FishingSafari f2 = fStore.get(21); // Existing FishingSafari

	//Tests

	// put (FishingSafari) - NEW
	fStore.put(f1);

	// put (FishingSafari) - UPDATE
	f2.setStatus(2);
	fStore.put(f2);

	// get methods
    }

    public static void main(String[] args) {
	new TestFishingSafariStorage();
    }
}
