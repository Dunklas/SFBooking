//package server.booking.control;

/*import server.booking.model.FishingSafariCatalog;
import client.ui.FishingSafariTopView;
import client.ui.FishingSafariBottomView;*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import org.jdatepicker.impl.*;

public class FishingSafariController {

	FishingSafariTopView topView;
	HashMap<Integer,Component> topMap;
	FishingSafariBottomView bottomView;
	HashMap<String,Component> bottomMap;
	
	
	public FishingSafariController(FishingSafariTopView tv){
		topView=tv;
		topMap=topView.getCompMap();
		bottomMap=bottomView.getCompMap();
		addDatePickerListener(topMap);
		addSaveSafariListener(bottomMap);
		
	}
	
	ActionListener datePickerListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="startDate"){
				// gör nånting
			}
		}
	};
	
	public void addDatePickerListener(HashMap<String,Component> map){
			JDatePickerImpl startDate = (JDatePickerImpl) map.get("startDate");
			JDatePickerImpl endDate = (JDatePickerImpl) map.get("endDate");
			
			startDate.addActionListener(datePickerListener);
			endDate.addActionListener(datePickerListener);
	}
	
	ActionListener saveFishingSafariListener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Component comp = (Component) e.getSource();
			if(comp.getName()=="saveFishingSafari"){
				// newFishingSafari(....);
			}
		}
	};
	
	public void addSaveSafariListener(HashMap<String,Component> map){
		JButton saveButton = (JButton) map.get("saveFishingSafari");
		saveButton.addActionListener(saveFishingSafariListener);
	}
	public void newFishingSafari(){
		
	}
	
	
}
