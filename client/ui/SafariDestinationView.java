package client.ui;

import javax.swing.JPanel;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.HashMap;

public class SafariDestinationView extends JPanel {
	private JTextField textFieldLocation;
	private JTextField textFieldParticipants;
	private JList<String> availableGearList;
	private JList<String> addedGearList;
	private JComboBox<String> guideBox;
	private JCheckBox terrain1;
	private JCheckBox terrain2;
	private JCheckBox terrain3;
        
	private JRadioButton activeButton;
	private JRadioButton inactiveButton;
	private ButtonGroup statusGroup = new ButtonGroup();
	private JButton saveNewSafariButton;
	
	private DefaultListModel<String> listModelAdded = new DefaultListModel<String>();
	private DefaultListModel<String> listModelAvailable = new DefaultListModel<String>();
	private ArrayList<JCheckBox> terrains = new ArrayList<JCheckBox>();
	
    private HashMap<String,Component> compMap = new HashMap<String,Component>();
	
	

	/**
	 * Create the panel.
	 */
	public SafariDestinationView() {
		
		
		setBackground(new Color(204, 204, 204));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{443, 0};
		gridBagLayout.rowHeights = new int[]{6, -5, 2, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPlats = new JLabel("Plats");
		GridBagConstraints gbc_lblPlats = new GridBagConstraints();
		gbc_lblPlats.anchor = GridBagConstraints.NORTH;
		gbc_lblPlats.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPlats.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlats.gridx = 0;
		gbc_lblPlats.gridy = 1;
		add(lblPlats, gbc_lblPlats);
		
		textFieldLocation = new JTextField();
		textFieldLocation.setName("location");
		textFieldLocation.setMinimumSize(new Dimension(100,20));
		GridBagConstraints gbc_textFieldLocation = new GridBagConstraints();
		gbc_textFieldLocation.ipadx = 99;
		gbc_textFieldLocation.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLocation.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldLocation.gridx = 0;
		gbc_textFieldLocation.gridy = 2;
		add(textFieldLocation, gbc_textFieldLocation);
		textFieldLocation.setColumns(10);
		
		JLabel lblMaxAntalDeltagare = new JLabel("Max antal deltagare");
		GridBagConstraints gbc_lblMaxAntalDeltagare = new GridBagConstraints();
		gbc_lblMaxAntalDeltagare.anchor = GridBagConstraints.WEST;
		gbc_lblMaxAntalDeltagare.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxAntalDeltagare.gridx = 0;
		gbc_lblMaxAntalDeltagare.gridy = 3;
		add(lblMaxAntalDeltagare, gbc_lblMaxAntalDeltagare);
		
		textFieldParticipants = new JTextField();
		textFieldParticipants.setName("participants");
		textFieldParticipants.setMinimumSize(new Dimension(100, 20));
		textFieldParticipants.setColumns(10);
		GridBagConstraints gbc_textFieldParticipants = new GridBagConstraints();
		gbc_textFieldParticipants.anchor = GridBagConstraints.WEST;
		gbc_textFieldParticipants.ipadx = 99;
		gbc_textFieldParticipants.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldParticipants.gridx = 0;
		gbc_textFieldParticipants.gridy = 4;
		add(textFieldParticipants, gbc_textFieldParticipants);
		
		JLabel lblTerrngtyp = new JLabel("Terr\u00E4ngtyp");
		GridBagConstraints gbc_lblTerrngtyp = new GridBagConstraints();
		gbc_lblTerrngtyp.anchor = GridBagConstraints.WEST;
		gbc_lblTerrngtyp.insets = new Insets(0, 0, 5, 0);
		gbc_lblTerrngtyp.gridx = 0;
		gbc_lblTerrngtyp.gridy = 5;
		add(lblTerrngtyp, gbc_lblTerrngtyp);
		
		JPanel terrainPanel = new JPanel();
		terrainPanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_terrainPanel = new GridBagConstraints();
		gbc_terrainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_terrainPanel.ipady = 15;
		gbc_terrainPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_terrainPanel.gridx = 0;
		gbc_terrainPanel.gridy = 6;
		add(terrainPanel, gbc_terrainPanel);
		terrainPanel.setLayout(new BoxLayout(terrainPanel, BoxLayout.X_AXIS));
		
		terrain1 = new JCheckBox("Terr\u00E4ng 1");
		terrain1.setName("terrain1");
		terrainPanel.add(terrain1);
		terrains.add(terrain1);
		
		terrain2 = new JCheckBox("Terr\u00E4ng 2");
		terrain2.setName("terrain2");
		terrainPanel.add(terrain2);
		terrains.add(terrain2);
		
		terrain3 = new JCheckBox("Terr\u00E4ng 3");
		terrain3.setName("terrain3");
		terrainPanel.add(terrain3);
		terrains.add(terrain3);
		

		JLabel lblAnsvarigGuide = new JLabel("Ansvarig guide");
		GridBagConstraints gbc_lblAnsvarigGuide = new GridBagConstraints();
		gbc_lblAnsvarigGuide.anchor = GridBagConstraints.WEST;
		gbc_lblAnsvarigGuide.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnsvarigGuide.gridx = 0;
		gbc_lblAnsvarigGuide.gridy = 7;
		add(lblAnsvarigGuide, gbc_lblAnsvarigGuide);
		
		guideBox = new JComboBox<String>();
		guideBox.addItem("Pelle");
		guideBox.setName("guideBox");
		guideBox.setPreferredSize(new Dimension(200, 26));
		GridBagConstraints gbc_guideBox = new GridBagConstraints();
		gbc_guideBox.ipadx = 99;
		gbc_guideBox.anchor = GridBagConstraints.WEST;
		gbc_guideBox.insets = new Insets(0, 0, 5, 0);
		gbc_guideBox.gridx = 0;
		gbc_guideBox.gridy = 8;
		add(guideBox, gbc_guideBox);
		guideBox.setMaximumSize(new Dimension(200, 25));
		
		JPanel guidePanel = new JPanel();
		guidePanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_guidePanel = new GridBagConstraints();
		gbc_guidePanel.insets = new Insets(0, 0, 5, 0);
		gbc_guidePanel.ipady = 15;
		gbc_guidePanel.anchor = GridBagConstraints.NORTH;
		gbc_guidePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_guidePanel.gridx = 0;
		gbc_guidePanel.gridy = 9;
		add(guidePanel, gbc_guidePanel);
		guidePanel.setLayout(new BoxLayout(guidePanel, BoxLayout.X_AXIS));
		
		JLabel lblUtrustning = new JLabel("Utrustning");
		GridBagConstraints gbc_lblUtrustning = new GridBagConstraints();
		gbc_lblUtrustning.anchor = GridBagConstraints.WEST;
		gbc_lblUtrustning.insets = new Insets(0, 0, 5, 0);
		gbc_lblUtrustning.gridx = 0;
		gbc_lblUtrustning.gridy = 10;
		add(lblUtrustning, gbc_lblUtrustning);
		
		JPanel gearPanel = new JPanel();
		gearPanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_gearPanel = new GridBagConstraints();
		gbc_gearPanel.insets = new Insets(0, 0, 5, 0);
		gbc_gearPanel.ipady = 99;
		gbc_gearPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_gearPanel.gridx = 0;
		gbc_gearPanel.gridy = 11;
		add(gearPanel, gbc_gearPanel);
		gearPanel.setLayout(new BoxLayout(gearPanel, BoxLayout.X_AXIS));
		
		JScrollPane availableGearScrollPane = new JScrollPane();
		availableGearScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearPanel.add(availableGearScrollPane);
		
		availableGearList = new JList<String>(listModelAvailable);
		availableGearList.setName("availableGearList");
		availableGearScrollPane.setViewportView(availableGearList);
		
		JPanel gearButtonPanel = new JPanel();
		gearPanel.add(gearButtonPanel);
		gearButtonPanel.setLayout(new BoxLayout(gearButtonPanel, BoxLayout.Y_AXIS));
		
		JButton addGearButton = new JButton("L\u00E4gg till >>");
		addGearButton.setName("addGearButton");
		gearButtonPanel.add(addGearButton);
		
		JButton removeGearButton = new JButton("<< Ta bort");
		removeGearButton.setName("removeGearButton");
		removeGearButton.setMaximumSize(new Dimension(105, 25));
		gearButtonPanel.add(removeGearButton);
		
		JScrollPane addedGearScrollPane = new JScrollPane();
		addedGearScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearPanel.add(addedGearScrollPane);
		
		fillUpList(); // testaLista
		addedGearList = new JList<String>(listModelAdded);
		addedGearList.setName("addedGearList");
		addedGearScrollPane.setViewportView(addedGearList);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(new Color(204, 204, 204));
		
		
		
		GridBagConstraints gbc_statusPanel = new GridBagConstraints();
		gbc_statusPanel.ipady = 15;
		gbc_statusPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_statusPanel.insets = new Insets(0, 0, 5, 0);
		gbc_statusPanel.gridx = 0;
		gbc_statusPanel.gridy = 12;
		add(statusPanel, gbc_statusPanel);
		
		activeButton = new JRadioButton("Bokningsbar");
		activeButton.setName("activeButton");
		activeButton.setVisible(false);
		statusPanel.add(activeButton);
		
		inactiveButton = new JRadioButton("Ej bokningsbar");
		inactiveButton.setName("inactiveButton");
		inactiveButton.setVisible(false);
		statusPanel.add(inactiveButton);
		
		statusGroup.add(activeButton); statusGroup.add(inactiveButton);
		
		saveNewSafariButton = new JButton("Save");
		saveNewSafariButton.setName("saveNewSafariButton");
		
		saveNewSafariButton.setMinimumSize(new Dimension(100, 25));
		GridBagConstraints gbc_saveNewSafariButton = new GridBagConstraints();
		gbc_saveNewSafariButton.anchor = GridBagConstraints.WEST;
		gbc_saveNewSafariButton.gridx = 0;
		gbc_saveNewSafariButton.gridy = 13;
		add(saveNewSafariButton, gbc_saveNewSafariButton);
		
		
		initCompMap();

	}
	public void initCompMap(){
		Component[] compArray = this.getComponents();
		for(int i=0; i<compArray.length; i++){
			compMap.put(compArray[i].getName(), compArray[i]);
		}
	}

	public HashMap<String,Component> getCompMap(){
	return compMap;
	
	}
	
	
	public void enableStatus(boolean status){ // kalla pa denna n'a'r det ska modifieras
		activeButton.setVisible(status);
		inactiveButton.setVisible(status);
	}
	
	public boolean checkStatus(){
		if(activeButton.isSelected()){
			return true;
		}
		else{
			return false;
		}
	}
	public String checkTerrain(){
		String result = "";
		
		for(JCheckBox c : terrains){
			if(c.isSelected()){
				result = result+c.getText()+";";	
			}
		}
		return result;
	}
	
	public String checkEquipment(DefaultListModel<String> list){
		String result = "";
		Object [] objList = list.toArray();
		String [] equipmentList = new String[objList.length];
		for(int i=0; i<objList.length; i++){
			equipmentList[i] = objList[i].toString();
		}
		for(int i=0; i<equipmentList.length; i++){
			
			result = result+equipmentList[i]+";";
		}
		return result;
	}
	public DefaultListModel<String> getListModel(){
		return listModelAdded;
	}
	
	
	public void fillUpList(){ // Dummylist representing list of available gear
		for(int i=0; i<10; i++){
			listModelAvailable.addElement("Stilton"+i);
		}

		
		
	}
	public void fillGuideBox(ArrayList<String> array){
	    for(int i = 0; i<array.size(); i++){
		guideBox.addItem(array.get(i));
		}
	}
	public void fillTerrain(ArrayList<String> array){
		for(int i = 0; i<array.size(); i++){
		    System.out.println(array.get(i));
		    if(array.get(i).equals("Terräng 1")){
         terrain1.setSelected(true);
			}
		    else if(array.get(i).equals("Terräng 2")){
				terrain2.setSelected(true);
			}
		    else if(array.get(i).equals("Terräng 3")){
				terrain3.setSelected(true);
			} else {
			    System.out.println("FAtTAR NADAccZz");
			}
		}
	}

	public void clearTerrain(){
		for(JCheckBox c : terrains){
       c.setSelected(false);
		}
	}

	public void clearSelection(){
		textFieldLocation.setText("");
		textFieldParticipants.setText("");
		clearTerrain();


	}
}
