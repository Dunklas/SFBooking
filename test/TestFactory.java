package test;

import server.customer.model.*;
import server.planning.model.*;
import server.utils.storage.*;
import java.util.*;

public class TestFactory {

    static Customer c;
    static SafariDestination sd;
    static ArrayList<FishingSafari> fs;

    public static void main(String[] args) {

	new TestFactory();

	System.out.println("Customer: " + c);
	System.out.println("SafariDestination: " + sd);
	for (FishingSafari f : fs) {
	    System.out.println("FishingSafari: " + f);
	}
    }

    public TestFactory() {

	c = CustomerStorageFactory.getStorage().get("wille@wille.com");
	sd = SafariDestinationStorageFactory.getStorage().get("Helge ¿¿");
	fs = FishingSafariStorageFactory.getStorage().get();
    }
}
