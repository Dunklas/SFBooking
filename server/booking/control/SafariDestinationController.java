package server.booking.control;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import server.booking.model.SafariDestinationCatalog;
import client.ui.SafariDestinationView; // kommentera ut dessa vid testning med databas och paketstruktur
import client.ui.ModifySafariDestinationView;


public class SafariDestinationController {

	SafariDestinationCatalog model;
	SafariDestinationView safariDestinationView;
	ModifySafariDestinationView modifySafariDestinationView;
	HashMap<String,Component> safariDestinationMap;
	HashMap<String,Component> modifySafariDestinationMap;
	
    public SafariDestinationController(SafariDestinationView sdv, SafariDestinationCatalog m, ModifySafariDestinationView msdv){
		model=m;
		safariDestinationView=sdv;
		modifySafariDestinationView=msdv;
		safariDestinationMap=safariDestinationView.getCompMap();
		modifySafariDestinationMap=modifySafariDestinationView.getCompMap();
	     	addListeners(safariDestinationMap,modifySafariDestinationMap);
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
			
			newSafariDestination(location,equipment,participants,guide,terrain);
		}   
		}	
	};
	
	ActionListener selectListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="selectButton"){
				
			}
		}
	    };
	
	public void addListeners(HashMap<String,Component> safariMap, HashMap<String,Component> modifyMap){
		
			JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
			saveButton.addActionListener(saveListener);
		
		
			//	JButton selectButton = (JButton) modifyMap.get("selectButton");
			//	selectButton.addActionListener(selectListener);
		
	}
	
	
	public void newSafariDestination(String location,String equipmentReq,int maxParticipants,String guide,String terrain){
	    model.newSafariDestination(location, equipmentReq, maxParticipants, guide, terrain);
	}
	
}
