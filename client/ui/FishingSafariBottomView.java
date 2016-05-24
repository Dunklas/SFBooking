package client.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.util.*;
import javax.swing.JComponent;
import javax.swing.DefaultListModel;
import javax.swing.text.JTextComponent;
import server.planning.model.SafariDestination;
import server.planning.model.FishingSafari;


public class FishingSafariBottomView extends JPanel {
	private JTextField startTimeTextfield;
	private JTextField endTimeTextfield;
	private JComboBox<SafariDestination> destinationPicker;
	private JComboBox<String> statusPicker;
	private JTextArea commentTextArea;
	private JButton saveFishingSafariButton;
	private JTextArea equipmentReq;
	


	DefaultListModel<String> equipmentListModel = new DefaultListModel<String>();

	private HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();
	ArrayList<JComponent> compArray = new ArrayList<JComponent>();

	FishingSafari fishingSafari;
	SafariDestination destination;

	
	public FishingSafariBottomView() {
		setMaximumSize(new Dimension(1000, 860));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftFormPanel = new JPanel();
		add(leftFormPanel);
		leftFormPanel.setLayout(new BoxLayout(leftFormPanel, BoxLayout.Y_AXIS));
		
		JPanel startTimePanel = new JPanel();
		startTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftFormPanel.add(startTimePanel);
		startTimePanel.setLayout(new BoxLayout(startTimePanel, BoxLayout.X_AXIS));
		
		JLabel startTimeLabel = new JLabel("Startdatum");
		startTimePanel.add(startTimeLabel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(20, 20));
		startTimePanel.add(horizontalStrut_1);
		
		startTimeTextfield = new JTextField();
		compArray.add(startTimeTextfield);
		startTimeTextfield.setName("startTime");
		startTimePanel.add(startTimeTextfield);
		startTimeTextfield.setMaximumSize(new Dimension(250, 25));
		startTimeTextfield.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		leftFormPanel.add(verticalStrut);
		
		JPanel endTimePanel = new JPanel();
		endTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftFormPanel.add(endTimePanel);
		endTimePanel.setLayout(new BoxLayout(endTimePanel, BoxLayout.X_AXIS));
		
		JLabel endTimeLabel = new JLabel("Slutdatum");
		endTimePanel.add(endTimeLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(25);
		horizontalStrut.setMaximumSize(new Dimension(25, 20));
		endTimePanel.add(horizontalStrut);
		
		endTimeTextfield = new JTextField();
		compArray.add(endTimeTextfield);
		endTimeTextfield.setName("endTime");
	
		endTimeTextfield.setMaximumSize(new Dimension(250, 25));
		endTimePanel.add(endTimeTextfield);
		endTimeTextfield.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		leftFormPanel.add(verticalStrut_1);
		
		JPanel pickLocationPanel = new JPanel();
		pickLocationPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftFormPanel.add(pickLocationPanel);
		pickLocationPanel.setLayout(new BoxLayout(pickLocationPanel, BoxLayout.X_AXIS));
		
		JLabel locationLabel = new JLabel("Safarim\u00E5l");
		pickLocationPanel.add(locationLabel);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(10);
		horizontalStrut_2.setMaximumSize(new Dimension(20, 20));
		pickLocationPanel.add(horizontalStrut_2);
		
		destinationPicker = new JComboBox<SafariDestination>();
		compArray.add(destinationPicker);
		destinationPicker.setName("destinationPicker");
		destinationPicker.setMaximumSize(new Dimension(150, 25));
		pickLocationPanel.add(destinationPicker);
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		leftFormPanel.add(verticalStrut_2);
		
		JPanel pickStatusPanel = new JPanel();
		pickStatusPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftFormPanel.add(pickStatusPanel);
		pickStatusPanel.setLayout(new BoxLayout(pickStatusPanel, BoxLayout.X_AXIS));
		
		JLabel statusLabel = new JLabel("Status");
		pickStatusPanel.add(statusLabel);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(35);
		horizontalStrut_3.setMaximumSize(new Dimension(38, 20));
		pickStatusPanel.add(horizontalStrut_3);
		
		statusPicker = new JComboBox<String>();
		compArray.add(statusPicker);
		statusPicker.setName("statusPicker");
		statusPicker.setMaximumSize(new Dimension(150, 25));
		pickStatusPanel.add(statusPicker);
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		leftFormPanel.add(verticalStrut_3);
		
		JPanel commentPanel = new JPanel();
		commentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		leftFormPanel.add(commentPanel);
		commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
		Component verticalStrut_comment = Box.createVerticalStrut(50);
		commentPanel.add(verticalStrut_comment);
		
		
		saveFishingSafariButton = new JButton("Spara");
		compArray.add(saveFishingSafariButton);
		saveFishingSafariButton.setName("saveFishingSafari");
		leftFormPanel.add(saveFishingSafariButton);
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setName("backButton");
		compArray.add(backButton);
		leftFormPanel.add(backButton);
		
		JPanel rightFormPanel = new JPanel();
		add(rightFormPanel);
		rightFormPanel.setLayout(new BoxLayout(rightFormPanel, BoxLayout.Y_AXIS));
		
		JPanel gearReqPanel = new JPanel();
		gearReqPanel.setMaximumSize(new Dimension(450, 110));
		rightFormPanel.add(gearReqPanel);
		gearReqPanel.setLayout(new BoxLayout(gearReqPanel, BoxLayout.Y_AXIS));
		
		JLabel gearReqLabel = new JLabel("Utrustningskrav");
		gearReqPanel.add(gearReqLabel);
		
	  equipmentReq = new JTextArea();
	  equipmentReq.setMaximumSize(new Dimension(400,200));
	  equipmentReq.setAlignmentX(Component.LEFT_ALIGNMENT);
		equipmentReq.setName("equipmentReq");
		gearReqPanel.add(equipmentReq);
		compArray.add(equipmentReq);
		
		

		initCompMap();
	}
	public void setText(String name,String text){
		try{
		JTextComponent comp = (JTextComponent) compMap.get(name);
		comp.setText(text);
	}
	catch(ClassCastException cce){
		cce.printStackTrace();
	}
}
public void setEnabled(String name,boolean status){
compMap.get(name).setEnabled(status);
}
public String getSelectedItem(String name){
	String selectedItem = "";
	try{
	JComboBox<String> comp = (JComboBox<String>) compMap.get(name);
	selectedItem = comp.getSelectedItem().toString();
}
catch(ClassCastException cce){
	cce.printStackTrace();
}
return selectedItem;
}


	public void initCompMap(){
		
		for(JComponent comp : compArray){
			compMap.put(comp.getName(), comp);
		}
	}
	public HashMap<String,JComponent> getCompMap(){
		return compMap;
	}

	public void clearSelection(){
		startTimeTextfield.setText("");
		endTimeTextfield.setText("");
		setEnabled("startTime",true);
		setEnabled("endTime",true);
		destinationPicker.setSelectedIndex(1);
		equipmentReq.setText("");
	}


	public void fillDestinationPicker(ArrayList<SafariDestination> array){
		for(SafariDestination destination : array){
			destinationPicker.addItem(destination);
		}
	}
	public void updateDestinationPicker(ArrayList<SafariDestination> array){
		destinationPicker.removeAllItems();
		for(SafariDestination destination : array){
			destinationPicker.addItem(destination);
		}
		
	}
	public void setSelectedDestinationIndex(SafariDestination destination){
		int amountDestinations = destinationPicker.getItemCount();
		SafariDestination currentDestination;
		for(int i=0; i<amountDestinations; i++){
			currentDestination = destinationPicker.getItemAt(i);
			if(currentDestination.equals(destination)){
				destinationPicker.setSelectedIndex(i);
			}
		}
	}

}
