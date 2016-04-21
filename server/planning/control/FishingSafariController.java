package server.planning.control;

import server.planning.model.FishingSafariCatalog;
import server.planning.model.SafariDestinationCatalog;
import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;
import client.ui.ModifyFishingSafariView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import org.jdatepicker.impl.*;

public class FishingSafariController {

	FishingSafariTopView topView;
	HashMap<String,Component> topMap;
	FishingSafariBottomView bottomView;
	HashMap<String,Component> bottomMap;
	ModifyFishingSafariView modifyView;
	HashMap<String,Component> modifyMap;
	
	SafariDestinationCatalog destinationModel; // needed when creating new FishingSafari
	FishingSafariCatalog fishingModel;
	
	
	public FishingSafariController(FishingSafariTopView fstv,FishingSafariBottomView fsbv,ModifyFishingSafariView mfsv,
			FishingSafariCatalog fsc,SafariDestinationCatalog sdc){
		destinationModel = sdc; 
		fishingModel = fsc;
		
		topView = fstv;
		topMap = topView.getCompMap();
		bottomView = fsbv;
		bottomMap = bottomView.getCompMap();
		modifyView = mfsv;
		modifyMap = modifyView.getCompMap();
		addListeners(topMap, bottomMap);
		
		
	}

	
	
	public void newFishingSafari(){
		
	}
	
	/**
	 * Adds listeners to components from a HashMap. HashMap derives from View-classes.
	 * 
	 * @param topMap HashMap from FishingSafariTopView-class
	 * @param bottomMap HashMap from FishingSafariBottomView-class
	 */
	public void addListeners(HashMap<String,Component> topMap,HashMap<String,Component> bottomMap){
		//1st add components from topView
		JDatePickerImpl startDate = (JDatePickerImpl) topMap.get("startDate"); 
		JDatePickerImpl endDate = (JDatePickerImpl) topMap.get("endDate");
		startDate.addActionListener(datePickerListener);
		endDate.addActionListener(datePickerListener);
		
		//2nd add components from bottomView
		JButton saveButton = (JButton) bottomMap.get("saveFishingSafari");
		saveButton.addActionListener(saveFishingSafariListener);
}

	/**
	 * Listeners
	 */
	ActionListener saveFishingSafariListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="saveFishingSafari"){
				
			}
		}
	};
	
	ActionListener datePickerListener = new ActionListener(){ // Is this needed?
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="startDate"){
				// do something
			}
		}
	};
	
	
}