package client.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;

import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import java.util.Properties;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.*;
import java.sql.Date;
import javax.swing.*;
import java.awt.*;


public class FishingSafariTopView extends JPanel {

private JButton selectEndDateButton;
private JButton selectStartDateButton;
private JDatePickerImpl endDatePicker;
private JDatePickerImpl startDatePicker;

	HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();
	ArrayList<JComponent> compArray = new ArrayList<JComponent>();
	
	public FishingSafariTopView() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		UtilDateModel startDateModel = new UtilDateModel();
		Properties propStart = new Properties();
		propStart.put("text.today","Today");
		propStart.put("text.month", "Month");
		propStart.put("text.year", "Year");
		
		JPanel leftDatePickerPanel = new JPanel();
		add(leftDatePickerPanel);
		JDatePanelImpl startDatePanel = new JDatePanelImpl(startDateModel,propStart);
		startDatePicker = new JDatePickerImpl(startDatePanel,new DateComponentFormatter());
		compArray.add(startDatePicker);
		startDatePicker.setName("startDate");
		leftDatePickerPanel.add(startDatePicker);
		
		selectStartDateButton = new JButton("V\u00E4lj");
		selectStartDateButton.setName("selectStartDate");
		compArray.add(selectStartDateButton);
		leftDatePickerPanel.add(selectStartDateButton);

		UtilDateModel endDateModel = new UtilDateModel();
		Properties propEnd = new Properties();
		propEnd.put("text.today","Today");
		propEnd.put("text.month", "Month");
		propEnd.put("text.year", "Year");
		
		
		JPanel rightDatePickerPanel = new JPanel();
		add(rightDatePickerPanel);
		JDatePanelImpl endDatePanel = new JDatePanelImpl(endDateModel,propEnd); 
		endDatePicker = new JDatePickerImpl(endDatePanel,new DateComponentFormatter());
		compArray.add(endDatePicker);
		endDatePicker.setName("endDate");
		rightDatePickerPanel.add(endDatePicker);
		
		selectEndDateButton = new JButton("V\u00E4lj");
		selectEndDateButton.setName("selectEndDate");
		compArray.add(selectEndDateButton);
		rightDatePickerPanel.add(selectEndDateButton);
		
		initCompMap();

	}
	public void initCompMap(){
		
		for(JComponent comp : compArray){
			compMap.put(comp.getName(), comp);
		}
	}
	public HashMap<String,JComponent> getCompMap(){
		return compMap;
	}

}
