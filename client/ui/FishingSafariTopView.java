package client.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;

import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import java.util.Properties;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.*;


public class FishingSafariTopView extends JPanel {

	HashMap<String,Component> compMap = new HashMap<String,Component>();
	ArrayList<Component> compArray = new ArrayList<Component>();
	
	public FishingSafariTopView() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		UtilDateModel model = new UtilDateModel();
		Properties prop = new Properties();
		prop.put("text.today","Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");
		
		JPanel leftDatePickerPanel = new JPanel();
		add(leftDatePickerPanel);
		JDatePanelImpl startDatePanel = new JDatePanelImpl(model,prop);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(startDatePanel,new DateComponentFormatter());
		compArray.add(startDatePicker);
		startDatePicker.setName("startDate");
		leftDatePickerPanel.add(startDatePicker);
		
		JPanel rightDatePickerPanel = new JPanel();
		add(rightDatePickerPanel);
		JDatePanelImpl endDatePanel = new JDatePanelImpl(model,prop); 
		JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel,new DateComponentFormatter());
		compArray.add(endDatePicker);
		endDatePicker.setName("endDate");
		rightDatePickerPanel.add(endDatePicker);
		
		initCompMap();

	}
	public void initCompMap(){
		
		for(int i=0; i<compArray.size(); i++){
			compMap.put(compArray.get(i).getName(), compArray.get(i));
		}
	}
	public HashMap<String,Component> getCompMap(){
		return compMap;
	}

}
