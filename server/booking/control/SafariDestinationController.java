import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SafariDestinationController {

	SafariDestinationView view;
	HashMap<String,Component> map;
	
	public SafariDestinationController(SafariDestinationView v){
		view=v;
		map=view.getCompMap();
		addListeners(map);
	}
	
	ActionListener saveListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
		Component comp = (Component) e.getSource();
		if(comp.getName()=="saveNewSafariButton"){
			JTextField locationText = (JTextField) map.get("location");
			String location = locationText.getText();
			
			JList equipmentList = (JList) map.get("addedGearList");
			String equipment = view.checkEquipment(equipmentList);
			
			JTextField participantsText = (JTextField) map.get("participants");
			int participants = Integer.parseInt(participantsText.getText()); // Vart ska vi hantera verifiering av input
			
			JComboBox<String> guideBox = (JComboBox<String>) map.get("guideBox");
			String guide = guideBox.getSelectedItem().toString();
			
			
			String terrain = view.checkTerrain(view.getTerrain());
			
			newSafariDestination(location,equipment,participants,guide,terrain);
		}
		
		       
		}
		
	
	};
	
	public void addListeners(HashMap<String,Component> map){
		for(int i=0; i<map.size(); i++){
			JButton saveButton = (JButton) map.get("saveNewSafariButton");
			saveButton.addActionListener(saveListener);
		}
	}
	
	
	public void newSafariDestination(String location,String equipmentReq,int maxParticipants,String guide,String terrain){
		
	}
	
}
