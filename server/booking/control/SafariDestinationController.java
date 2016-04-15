package server.booking.control;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import server.booking.model.SafariDestinationCatalog;
import client.ui.SafariDestinationView; 
import client.ui.ModifySafariDestinationView;
import server.booking.model.SafariDestination;
import java.sql.*;

public class SafariDestinationController {

	
	/**
	 * Declare objects to be used by created objects of this class
	 */
	SafariDestinationCatalog model; 
	SafariDestinationView safariDestinationView;
	ModifySafariDestinationView modifySafariDestinationView;
	HashMap<String,Component> safariDestinationMap;
	HashMap<String,Component> modifySafariDestinationMap;
	
	boolean modSelected = false;
	
    public SafariDestinationController(SafariDestinationView sdv, SafariDestinationCatalog m, ModifySafariDestinationView msdv){
		/**
		 * Initiates objects and maps to be used by this controller
		 */
    	model=m;
		safariDestinationView = sdv;
		modifySafariDestinationView = msdv;
		safariDestinationMap = safariDestinationView.getCompMap();
		modifySafariDestinationMap = modifySafariDestinationView.getCompMap();
	    addListeners(safariDestinationMap,modifySafariDestinationMap);
		
	    try{
	     	modifySafariDestinationView.fillList(model.selectAllSafariDestination()); // move this when main menu is available
	     	safariDestinationView.fillGuideBox(model.selectAllGuides()); 
		}catch (SQLException se){

		}
		}
	
	ActionListener saveListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		Component comp = (Component) e.getSource();
		if(comp.getName()=="saveNewSafariButton"){
			
			JTextField locationText = (JTextField) safariDestinationMap.get("location");
			String location = locationText.getText();
			
			
			String equipment = safariDestinationView.checkEquipment(safariDestinationView.getListModel());
			
			JTextField participantsText = (JTextField) safariDestinationMap.get("participants");
			int participants = Integer.parseInt(participantsText.getText()); // Vart ska vi hantera verifiering av input
			
			JComboBox<String> guideBox = (JComboBox<String>) safariDestinationMap.get("guideBox");
			String guide = guideBox.getSelectedItem().toString();
			
			
			String terrain = safariDestinationView.checkTerrain();
			
			boolean active = safariDestinationView.checkStatus();
			
			if(modSelected==false){
				model.newSafariDestination(location, equipmentReq, maxParticipants, guide, terrain);
		} 
			else if(modSelected==true){
				
			    //active
				model.updateSafariDestination(location,equipment,participants,guide,terrain,active);
				modSelected(false);
			}
		}	
	};
	
	ActionListener selectListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="selectButton"){
				
				modSelected = true;
				JList<String> modifyList = (JList<String>) safariDestinationMap.get("modifyList");
				
				String selected = modifySafariDestinationView.getValues();
				
				try{
				SafariDestination newSafari = model.selectSafariDestination(selected);
				
				JTextField locationText = (JTextField) safariDestinationMap.get("location");
				locationText.setText(newSafari.getLocation());
				
				JTextField maxParticipantsText = (JTextField) safariDestinationMap.get("participants");
				maxParticipantsText.setText(""+newSafari.getMaxParticipants());
				
				JComboBox<String> guideBox = (JComboBox<String>) safariDestinationMap.get("guideBox");
				guideBox.setSelectedItem(newSafari.getGuide());
				
				
				
				} catch (SQLException se){
				    System.out.println("HÄR BLEV DET FEL I BAIAN");
				}
			}
		}
	    };
	
    public void addListeners(HashMap<String,Component> safariMap, HashMap<String,Component> modifyMap){
		
			JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
			saveButton.addActionListener(saveListener);
		
		
			JButton selectButton = (JButton) modifyMap.get("selectButton");
			selectButton.addActionListener(selectListener);
		
	}
	
	
	
	
	
}
