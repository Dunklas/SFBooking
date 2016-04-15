package client.ui;

import javax.swing.*;
import server.booking.control.*;
import server.booking.model.*;
import java.sql.*;
import java.util.*;


public class MainWindow {

	/**
	 * Initiate Model,View and Controllers
	 */
	SafariDestinationView sdv = new SafariDestinationView();
	SafariDestinationCatalog sdc = new SafariDestinationCatalog();
    ModifySafariDestinationView msdv = new ModifySafariDestinationView();
	SafariDestinationController sdcontroller = new SafariDestinationController(sdv, sdc,msdv);
	
	FishingSafariTopView fstv = new FishingSafariTopView();
	FishingSafariBottomView fsbv = new FishinSafariBottomView();
	FishingSafariCatalog fsc = new FishingSafariCatalog();
	FishingSafariController fsc = new FishingSafariController(fstv,fsbv,fsc,sdc); //ok att anv'a'nda samma sdc-objekt?

    public static void main (String [] args){
    	
    	



    }





}
