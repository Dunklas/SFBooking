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

    public static void main (String [] args){
	SafariDestinationView sdv = new SafariDestinationView();
	SafariDestinationCatalog sdc = new SafariDestinationCatalog();
    ModifySafariDestinationView msdv = new ModifySafariDestinationView();
	SafariDestinationController sdcontroller = new SafariDestinationController(sdv, sdc,msdv);
	
	FishingSafariTopView fstv = new FishingSafariTopView();
	FishingSafariBottomView fsbv = new FishingSafariBottomView();
	FishingSafariCatalog fsc = new FishingSafariCatalog();
	FishingSafariController fscd = new FishingSafariController(fstv,fsbv,fsc,sdc); //ok att anv'a'nda samma sdc-objekt?
    	
	MainSplitView mv = new MainSplitView(sdv,msdv);



    }




}
