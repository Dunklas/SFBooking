package client.ui;

import javax.swing.*;
import server.planning.control.*;
import server.planning.model.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

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
  MainSplitView split;

  JButton safariButton;
  JButton fishingButton;
    public static void main (String [] args){
	
    new MainWindow();

    }
	
	public MainWindow(){
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(1000,800));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		safariButton = new JButton("Safarimålshanterare");
		fishingButton = new JButton("Fiskesafarihanterare");
		safariButton.addActionListener(mainListener);
		fishingButton.addActionListener(mainListener);

		mainPanel.add(safariButton); mainPanel.add(fishingButton);

		add(mainPanel);
	}

	ActionListener mainListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
     if(e.getSource()==safariButton){
         split = new MainSplitView(msdv,sdv);
         JFrame safariFrame = new JFrame();
         safariFrame.setVisible(true);
         safariFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         safariFrame.setSize(1000,800);
         safariFrame.add(split);
     }
     else if(e.getSource()==fishingButton){
         JPanel mainFishingPanel = new JPanel();
         mainFishingPanel.setLayout(new GridLayout(2,1));
         mainFishingPanel.add(fstv);
         mainFishingPanel.add(fsbv);

         split = new MainSplitView(mfsv,mainFishingPanel);
         JFrame fishingFrame = new JFrame();
         fishingFrame.setVisible(true);
         fishingFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
         fishingFrame.setSize(1000,800);
         fishingFrame.add(split);
     }  
		}
	};


	




}
