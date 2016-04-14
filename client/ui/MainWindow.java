package client.ui;

import javax.swing.*;
import server.booking.control.*;
import server.booking.model.*;
import java.sql.*;
import java.util.*;


public class MainWindow {


    public static void main (String [] args){
    	SafariDestinationView sdv = new SafariDestinationView();
    	SafariDestinationCatalog sdc = new SafariDestinationCatalog();
        ModifySafariDestinationView msdv = new ModifySafariDestinationView();
        try{
        msdv.fillList(sdc.selectAllSafariDestination());
        }
        catch(SQLException e){
        	//
        }
        MainSplitView split = new MainSplitView(msdv,sdv);
	
	SafariDestinationController sdcontroller = new SafariDestinationController(sdv, sdc,msdv);

	JFrame jf = new JFrame();
	jf.add(split);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	


    }





}
