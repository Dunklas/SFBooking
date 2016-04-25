package server.planning.control;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import server.planning.model.SafariDestinationCatalog;
import client.ui.SafariDestinationView; 
import client.ui.ModifySafariDestinationView;
import server.planning.model.SafariDestination;
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
	
	SafariDestination newSafari; // declare object here to be created when needed during updatingphase
	
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
    
    /**
     * Listeners
     */
	
	ActionListener saveListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		Component comp = (Component) e.getSource();
		if(comp.getName()=="saveNewSafariButton"){
			
			JTextField locationText = (JTextField) safariDestinationMap.get("location");
			String location = locationText.getText();
			
			
			String equipment = safariDestinationView.checkEquipment(safariDestinationView.getListModelAdded());
			
			JTextField participantsText = (JTextField) safariDestinationMap.get("participants");
			int participants = Integer.parseInt(participantsText.getText()); // Vart ska vi hantera verifiering av input
			
			JComboBox<String> guideBox = (JComboBox<String>) safariDestinationMap.get("guideBox");
			String guide = guideBox.getSelectedItem().toString();
			
			
			String terrain = safariDestinationView.checkTerrain();
			
			boolean active = safariDestinationView.checkStatus();
			
			if(modSelected==false){
				model.newSafariDestination(location, equipment, participants, guide, terrain);
				safariDestinationView.clearSelection();
        try{
				modifySafariDestinationView.fillList(model.selectAllSafariDestination());
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		} 
			else if(modSelected==true){
				  
			    setUpdatedFields(equipment,participants,guide,terrain,active,newSafari); // see method below
				  safariDestinationView.clearSelection();
				  safariDestinationView.enableStatus(false);
				modSelected = false;
			}
		}	
	}
	    };	
	ActionListener selectListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="selectButton"){
				safariDestinationView.clearTerrain();

				modSelected = true;
				JList<String> modifyList = (JList<String>) safariDestinationMap.get("modifyList");
				
				String selectedDestination = modifySafariDestinationView.getSelectedDestination();
				safariDestinationView.enableStatus(true);
				
				try{
				newSafari = model.selectSafariDestination(selectedDestination);
				
				JTextField locationText = (JTextField) safariDestinationMap.get("location");
				locationText.setText(newSafari.getLocation());
				locationText.setEnabled(false); // sets textfield disabled while modifying existing destination
				
				JTextField maxParticipantsText = (JTextField) safariDestinationMap.get("participants");
				maxParticipantsText.setText(""+newSafari.getMaxParticipants());
				
				JComboBox<String> guideBox = (JComboBox<String>) safariDestinationMap.get("guideBox"); 
				guideBox.setSelectedItem(newSafari.getGuide());
				
				safariDestinationView.fillTerrain(newSafari.getEquipmentReq());

				safariDestinationView.setActive(newSafari.getActive());


				
				
				} catch (SQLException se){
				    System.out.println("HÄR BLEV DET FEL I BAIAN");
				}
			}
		}
	    };

	    ActionListener equipmentListener = new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
         Component comp = (Component) e.getSource();
         DefaultListModel<String> addedListModel = safariDestinationView.getListModelAdded();
         DefaultListModel<String> availableListModel = safariDestinationView.getListModelAvailable();

         JList<String> addedList = (JList<String>) safariDestinationMap.get("addedGearList");
         JList<String> availableList = (JList<String>) safariDestinationMap.get("availableGearList");

         if(comp.getName()=="addGearButton"){
	     for(String s : availableList.getSelectedValuesList()){
           addedListModel.addElement(s);
           availableListModel.removeElement(s);
         }
	 }
         else if(comp.getName()=="removeGearButton"){
         	for(String s : addedList.getSelectedValuesList()){
           availableListModel.addElement(s);
           addedListModel.removeElement(s);
         }
         }
	    	}
	    };
	
	    /**
	     * Adds listeners
	     */
    public void addListeners(HashMap<String,Component> safariMap, HashMap<String,Component> modifyMap){
		
			JButton saveButton = (JButton) safariMap.get("saveNewSafariButton");
			saveButton.addActionListener(saveListener);
		
		
			JButton selectButton = (JButton) modifyMap.get("selectButton");
			selectButton.addActionListener(selectListener);

      JButton addButton = (JButton) safariMap.get("addGearButton");
      addButton.addActionListener(equipmentListener);

      JButton removeButton = (JButton) safariMap.get("removeGearButton");
      removeButton.addActionListener(equipmentListener);
		
	}
    
    /**
     *Methods for converting data etc 
     *
     */
    public ArrayList<String> convertTerrainFromDb(SafariDestination destination){
	ArrayList<String> parsedTerrain = new ArrayList<String>();
    	
    	String tempDest = destination.getLocation();
	try{
	String result = destination.getSafariDestinationElement(tempDest, "terrain");
	Scanner parser = new Scanner(result).useDelimiter(";");

	while(parser.hasNext()){
		parsedTerrain.add(parser.next());

	}


	} catch (SQLException se){
	    System.out.println(se.getMessage());
	    System.out.println("fel i safaridestinationcontroller");
	}
	return parsedTerrain;
    }

    public void setUpdatedFields(String equipment,int participants,String guide,String terrain,
    		boolean active,SafariDestination destination){
    	destination.setEquipmentReq(equipment);
    	destination.setMaxParticipants(participants);
    	destination.setGuide(guide);
    	destination.setTerrain(terrain);
    	destination.setStatus(active);
    	
    }
    
    
}
	
	
	
      	    

