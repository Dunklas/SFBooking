package client.ui;

import javax.swing.*;
import server.booking.control.*;
import server.booking.model.*;


public class MainWindow {


    public static void main (String [] args){
	SafariDestinationCatalog sdc = new SafariDestinationCatalog();

	SafariDestinationView view = new SafariDestinationView();
	SafariDestinationController sdcontroller = new SafariDestinationController(view, sdc);

	JFrame jf = new JFrame();
	jf.add(view);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	


    }





}
