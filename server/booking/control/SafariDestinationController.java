package server.booking.control;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import server.booking.model.SafariDestinationCatalog;
import client.ui.SafariDestinationView; // kommentera ut dessa vid testning med databas och paketstruktur

public class SafariDestinationController {

	SafariDestinationCatalog model;
	SafariDestinationView safariDestinationView;
	ModifySafariDestinationView modifyDestinationView;
	HashMap<String,Component> safariDestinationMap;
	HashMap<String,Component> modifySafariDestinationMap;
	
    public SafariDestinationController(SafariDestinationView sdv, SafariDestinationCatalog m, ModifySafariDestinationView msdv){
		model=m;
		safariDestinationView=sdv;
		modifySafariDestinationView=msdv
		safariDestinationMap=sdv.getCompMap();
		modifySafariDestinationMap=msdv.getCompMap();
		addListeners(safariDestinationMap,modifySafariDestinationMap());
	}
	
	ActionListener saveListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		Component comp = (Component) e.getSource();
		if(comp.getName()=="saveNewSafariButton"){
			JTextField locationText = (JTextField) safariDestinationMap.get("location");
			String location = locationText.getText();
			
			//JList<String> equipmentList = (JList<String>) map.get("addedGearList");
			String equipment = view.checkEquipment(view.getListModel());
			
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
				// Välj vald Safarimål, skicka vidare till model->databas..
			}
		}
	}
	
	public void addListeners(HashMap<String,Component> safariMap, HashMap<String,Component> modifyMap){
		
			JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
			saveButton.addActionListener(saveListener);
		
		
			JButton selectButton = (JButton) modifyMap("selectButton");
			selectButton.addActionListener(selectListener);
		
	}
	
	
	public void newSafariDestination(String location,String equipmentReq,int maxParticipants,String guide,String terrain){
	    model.newSafariDestination(location, equipmentReq, maxParticipants, guide, terrain);
	}
	
}
