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
import server.planning.model.SafariDestination;
import server.planning.model.FishingSafari;


public class FishingSafariBottomView extends JPanel {
	private JTextField startTimeTextfield;
	private JTextField endTimeTextfield;
	private JComboBox<String> destinationPicker;
	private JComboBox<String> statusPicker;
	private JTextArea commentTextArea;
	private JButton saveFishingSafariButton;
	private JTextArea equipmentReq;
	private JList<String> gearAvailableList;
	private JButton addGearToRentButton;
	private JButton removeGearToRentButton;
	private JList<String> addedGearToRentList;


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
		
		JLabel startTimeLabel = new JLabel("Starttid");
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
		
		JLabel endTimeLabel = new JLabel("Sluttid");
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
		
		destinationPicker = new JComboBox<String>();
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
		
		JLabel commentLabel = new JLabel("Kommentar");
		commentPanel.add(commentLabel);
		
		commentTextArea = new JTextArea();
		compArray.add(commentTextArea);
		commentTextArea.setName("commentArea");
		commentTextArea.setMaximumSize(new Dimension(400, 100));
		commentTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		commentPanel.add(commentTextArea);
		
		saveFishingSafariButton = new JButton("Spara");
		compArray.add(saveFishingSafariButton);
		saveFishingSafariButton.setName("saveFishingSafari");
		leftFormPanel.add(saveFishingSafariButton);
		
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
		equipmentReq.setName("equipmentReq");
		gearReqPanel.add(equipmentReq);
		compArray.add(equipmentReq);
		
		Component verticalStrut_4 = Box.createVerticalStrut(30);
		verticalStrut_4.setMaximumSize(new Dimension(30, 30));
		rightFormPanel.add(verticalStrut_4);
		
		JLabel gearToRentLabel = new JLabel("Utrustning att hyra ut:");
		gearToRentLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rightFormPanel.add(gearToRentLabel);
		
		JPanel gearToRentPanel = new JPanel();
		gearToRentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		gearToRentLabel.setLabelFor(gearToRentPanel);
		gearToRentPanel.setMaximumSize(new Dimension(550, 100));
		rightFormPanel.add(gearToRentPanel);
		gearToRentPanel.setLayout(new BoxLayout(gearToRentPanel, BoxLayout.X_AXIS));
		
		JScrollPane gearAvailableScrollPane = new JScrollPane();
		gearAvailableScrollPane.setPreferredSize(new Dimension(185, 100));
		gearAvailableScrollPane.setMaximumSize(new Dimension(150, 100));
		gearAvailableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearToRentPanel.add(gearAvailableScrollPane);
		
		gearAvailableList = new JList<String>();
		compArray.add(gearAvailableList);
		gearAvailableList.setName("availableGear");
		gearAvailableList.setAlignmentX(Component.LEFT_ALIGNMENT);
		gearAvailableScrollPane.setViewportView(gearAvailableList);
		
		JPanel gearToRentButtonPanel = new JPanel();
		gearToRentPanel.add(gearToRentButtonPanel);
		gearToRentButtonPanel.setLayout(new BoxLayout(gearToRentButtonPanel, BoxLayout.Y_AXIS));
		
		addGearToRentButton = new JButton("L\u00E4gg till >>");
		compArray.add(addGearToRentButton);
		addGearToRentButton.setName("addGear");
		gearToRentButtonPanel.add(addGearToRentButton);
		
		removeGearToRentButton = new JButton("<< Ta bort");
		compArray.add(removeGearToRentButton);
		removeGearToRentButton.setName("removeGear");
		removeGearToRentButton.setMaximumSize(new Dimension(88, 28));
		gearToRentButtonPanel.add(removeGearToRentButton);
		
		JScrollPane addedGearToRentScrollPane = new JScrollPane();
		addedGearToRentScrollPane.setPreferredSize(new Dimension(125, 100));
		addedGearToRentScrollPane.setMaximumSize(new Dimension(150, 100));
		addedGearToRentScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearToRentPanel.add(addedGearToRentScrollPane);
		
		addedGearToRentList = new JList<String>();
		compArray.add(addedGearToRentList);
		addedGearToRentList.setName("addedGear");
		addedGearToRentScrollPane.setViewportView(addedGearToRentList);

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



	public void fillDestinationPicker(ArrayList<SafariDestination> array){
		destinationPicker.addItem(""); // adds empty string as default when creating new Safari
		for(SafariDestination destination : array){

			destinationPicker.addItem(destination.getLocation());
		}
	}

}
