package server.planning.control;

import server.planning.model.FishingSafariCatalog;
import server.planning.model.SafariDestinationCatalog;
import server.planning.model.SafariDestination;
import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;
import client.ui.ModifyFishingSafariView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import org.jdatepicker.impl.*;
import java.sql.*;
import java.util.Date;

public class FishingSafariController {

	FishingSafariTopView topView;
	HashMap<String,Component> topMap;
	FishingSafariBottomView bottomView;
	HashMap<String,Component> bottomMap;
	ModifyFishingSafariView modifyView;
	HashMap<String,Component> modifyMap;
	
	SafariDestinationCatalog destinationModel; // needed when creating new FishingSafari
	FishingSafariCatalog fishingModel;

	Date selectedStartDate;
	Date selectedEndDate;
	
	
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
    fillModifyList();
		
		bottomView.fillDestinationPicker(getAllDestinations());
		
	}

	public void fillModifyList(){
		try{
			modifyView.fillList(fishingModel.selectAllFishingSafaris());
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}

	public ArrayList<String> getAllDestinations(){
		ArrayList<String> destinationList = new ArrayList<String>();
		try{
			  
        DefaultListModel<String> destinationListModel = destinationModel.selectAllSafariDestination();
        for(int i=0; i<destinationListModel.size(); i++){
        	destinationList.add(destinationListModel.getElementAt(i));
        }
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		return destinationList;
	}

	
	

	
	/**
	 * Adds listeners to components from a HashMap. HashMap derives from View-classes.
	 * 
	 * @param topMap HashMap from FishingSafariTopView-class
	 * @param bottomMap HashMap from FishingSafariBottomView-class
	 */
	public void addListeners(HashMap<String,Component> topMap,HashMap<String,Component> bottomMap){
		//1st add components from topView
		JButton startDate = (JButton) topMap.get("selectStartDate"); 
		JButton endDate = (JButton) topMap.get("selectEndDate");
		startDate.addActionListener(datePickerListener);
		endDate.addActionListener(datePickerListener);
		
		//2nd add components from bottomView
		JButton saveButton = (JButton) bottomMap.get("saveFishingSafari");
		saveButton.addActionListener(saveFishingSafariListener);

		JComboBox destinationPicker = (JComboBox) bottomMap.get("destinationPicker");
		destinationPicker.addItemListener(destinationListener);
}

	/**
	 * Listeners
	 */
	ActionListener saveFishingSafariListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="saveFishingSafari"){
				JComboBox<String> destinationPicker = (JComboBox<String>) bottomMap.get("destinationPicker");
				String destination = destinationPicker.getSelectedItem().toString();

				newFishingSafari(destination,selectedStartDate,selectedEndDate); // Have to handle exceptions in input...
			}
		}
	};
	
	ActionListener datePickerListener = new ActionListener(){ // Is this needed?
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="selectStartDate"){
				JTextField startTimeTextField = (JTextField) bottomMap.get("startTime");
				JDatePickerImpl startDatePicker = (JDatePickerImpl) topMap.get("startDate");
				
				startTimeTextField.setText(startDatePicker.getJFormattedTextField().getText());
				selectedStartDate = (Date) startDatePicker.getModel().getValue();
			}
			else if(comp.getName()=="selectEndDate"){
				JTextField endTimeTextField = (JTextField) bottomMap.get("endTime");
				JDatePickerImpl endDatePicker = (JDatePickerImpl) topMap.get("endDate");

        endTimeTextField.setText(endDatePicker.getJFormattedTextField().getText());
        selectedEndDate = (Date) endDatePicker.getModel().getValue();
			}
		}
	};

	ItemListener destinationListener = new ItemListener(){
		public void itemStateChanged(ItemEvent e){
        Component comp = (Component) e.getSource();
        if(comp.getName()=="destinationPicker"){
           JComboBox<String> destinationPicker = (JComboBox<String>) comp;
           String selectedDestination = destinationPicker.getSelectedItem().toString();
           JList<String> equipmentReq = (JList<String>) bottomMap.get("equipmentList");
           
           try{
           	SafariDestination destinationObject = destinationModel.selectSafariDestination(selectedDestination);
            bottomView.fillEquipmentList(destinationObject.getEquipmentReq(),equipmentReq);
           	

           }
           catch(SQLException se){
           	se.printStackTrace();
           }

           


        }
		}
	};



/**
*Method to create and insert new FishingSafari-instance into db
*/
		public void newFishingSafari(String destination,Date startDate, Date endDate){
		try{
		SafariDestination destinationObject = destinationModel.selectSafariDestination(destination);
		
    fishingModel.newFishingSafari(destinationObject,startDate,endDate);
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
	}
	public void updateFishingSafari(String destination,Date startDate, Date endDate, int status){
		/*try{
			// update FishingSafari-object
		
		
    
		}
		catch(SQLException se){
			se.printStackTrace();
		}*/
	}
	
	
}
