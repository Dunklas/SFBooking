package client.ui;

import javax.swing.*;
import server.booking.control.*;
import server.booking.model.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

public class MainWindow extends JFrame{

	/*
	 * Initiate Model,View and Controllers
	 **/
	SafariDestinationView sdv = new SafariDestinationView();
	SafariDestinationCatalog sdc = new SafariDestinationCatalog();
    ModifySafariDestinationView msdv = new ModifySafariDestinationView();
	SafariDestinationController sdcontroller = new SafariDestinationController(sdv, sdc,msdv);
	
	FishingSafariTopView fstv = new FishingSafariTopView();
	FishingSafariBottomView fsbv = new FishingSafariBottomView();
	ModifyFishingSafariView mfsv = new ModifyFishingSafariView();
	FishingSafariCatalog fsc = new FishingSafariCatalog();
	FishingSafariController fscd = new FishingSafariController(fstv,fsbv,mfsv,fsc,sdc); //ok att anv'a'nda samma sdc-objekt?

    public static void main (String [] args){
	
    new MainWindow();

    }
	
	public MainWindow(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(1000,800));
		
		MainSplitView split = new MainSplitView(msdv,sdv);
		add(split);
		
	}
	




}
