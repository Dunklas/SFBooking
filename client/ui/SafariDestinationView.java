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
import javax.swing.AbstractButton;
import javax.swing.text.JTextComponent;
import javax.swing.JComponent;
import server.planning.model.SafariDestination;

public class SafariDestinationView extends JPanel {
	private JTextField textFieldLocation;
	private JTextField textFieldParticipants;
	private JList<String> availableGearList;
	private JList<String> addedGearList;
	private JComboBox<String> guideBox;
	private JCheckBox terrain1;
	private JCheckBox terrain2;
	private JCheckBox terrain3;
	private JTextArea equipmentTextArea;
        
	private JRadioButton activeButton;
	private JRadioButton inactiveButton;
	private ButtonGroup statusGroup = new ButtonGroup();
	private JButton saveNewSafariButton;
	private JButton backButton;
	
	private DefaultListModel<String> listModelAdded = new DefaultListModel<String>();
	private DefaultListModel<String> listModelAvailable = new DefaultListModel<String>();
	private ArrayList<JCheckBox> terrains = new ArrayList<JCheckBox>();
	
    private HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();
    private ArrayList<JComponent> compArray = new ArrayList<JComponent>();

    private ArrayList<String> dummyEquipment = new ArrayList<String>();

    private SafariDestination destination;
	
	

	/**
	 * Create the panel.
	 */
	public SafariDestinationView() {
		
		
		setBackground(UIManager.getColor("CheckBox.light"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 0};
		gridBagLayout.rowHeights = new int[]{6, -5, 2, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		compArray.add(textFieldLocation);
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
		compArray.add(textFieldParticipants);
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
		terrainPanel.setBackground(UIManager.getColor("CheckBox.light"));
		GridBagConstraints gbc_terrainPanel = new GridBagConstraints();
		gbc_terrainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_terrainPanel.ipady = 15;
		gbc_terrainPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_terrainPanel.gridx = 0;
		gbc_terrainPanel.gridy = 6;
		add(terrainPanel, gbc_terrainPanel);
		terrainPanel.setLayout(new BoxLayout(terrainPanel, BoxLayout.X_AXIS));
		
		terrain1 = new JCheckBox("Terrain 1");
		terrain1.setName("terrain1");
		compArray.add(terrain1);
		terrainPanel.add(terrain1);
		terrains.add(terrain1);
		
		terrain2 = new JCheckBox("Terrain 2");
		terrain2.setName("terrain2");
		compArray.add(terrain2);
		terrainPanel.add(terrain2);
		terrains.add(terrain2);
		
		terrain3 = new JCheckBox("Terrain 3");
		terrain3.setName("terrain3");
		compArray.add(terrain3);
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
		guideBox.setName("guideBox");
		compArray.add(guideBox);
		guideBox.setPreferredSize(new Dimension(200, 26));
		GridBagConstraints gbc_guideBox = new GridBagConstraints();
		gbc_guideBox.ipadx = 99;
		gbc_guideBox.anchor = GridBagConstraints.WEST;
		gbc_guideBox.insets = new Insets(0, 0, 5, 0);
		gbc_guideBox.gridx = 0;
		gbc_guideBox.gridy = 8;
		add(guideBox, gbc_guideBox);
		guideBox.setMaximumSize(new Dimension(200, 25));

		guideBox.addItem("Jason");
		
		JPanel guidePanel = new JPanel();
		guidePanel.setBackground(UIManager.getColor("CheckBox.light"));
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
		gearPanel.setBackground(UIManager.getColor("CheckBox.light"));
		GridBagConstraints gbc_gearPanel = new GridBagConstraints();
		gbc_gearPanel.insets = new Insets(0, 0, 5, 0);
		gbc_gearPanel.ipady = 99;
		gbc_gearPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_gearPanel.gridx = 0;
		gbc_gearPanel.gridy = 11;
		add(gearPanel, gbc_gearPanel);
		gearPanel.setLayout(new BoxLayout(gearPanel, BoxLayout.X_AXIS));
		
		equipmentTextArea = new JTextArea();
		equipmentTextArea.setMaximumSize(new Dimension(500, 500));
		gearPanel.add(equipmentTextArea);
		compArray.add(equipmentTextArea);
		equipmentTextArea.setName("equipmentReq");
		
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(UIManager.getColor("CheckBox.light"));
		
		
		
		GridBagConstraints gbc_statusPanel = new GridBagConstraints();
		gbc_statusPanel.ipady = 15;
		gbc_statusPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_statusPanel.insets = new Insets(0, 0, 5, 0);
		gbc_statusPanel.gridx = 0;
		gbc_statusPanel.gridy = 12;
		add(statusPanel, gbc_statusPanel);
		
		activeButton = new JRadioButton("Bokningsbar");
		activeButton.setName("activeButton");
		compArray.add(activeButton);
		activeButton.setVisible(false);
		statusPanel.add(activeButton);
		
		inactiveButton = new JRadioButton("Ej bokningsbar");
		inactiveButton.setName("inactiveButton");
		compArray.add(inactiveButton);
		inactiveButton.setVisible(false);
		statusPanel.add(inactiveButton);
		
		statusGroup.add(activeButton); statusGroup.add(inactiveButton);
		
		saveNewSafariButton = new JButton("Spara");
		saveNewSafariButton.setName("saveNewSafariButton");
		compArray.add(saveNewSafariButton);
		
		saveNewSafariButton.setMinimumSize(new Dimension(100, 25));
		GridBagConstraints gbc_saveNewSafariButton = new GridBagConstraints();
		gbc_saveNewSafariButton.insets = new Insets(0, 0, 5, 0);
		gbc_saveNewSafariButton.anchor = GridBagConstraints.WEST;
		gbc_saveNewSafariButton.gridx = 0;
		gbc_saveNewSafariButton.gridy = 13;
		add(saveNewSafariButton, gbc_saveNewSafariButton);
		
		backButton = new JButton("Tillbaka");
		backButton.setName("backButton");
		compArray.add(backButton);
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.anchor = GridBagConstraints.WEST;
		gbc_backButton.insets = new Insets(0, 0, 0, 10);
		gbc_backButton.gridx = 0;
		gbc_backButton.gridy = 14;
		add(backButton, gbc_backButton);
		
		
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

	
	public void setText(String name, String text){
    try{
		JTextComponent textComp = (JTextComponent) compMap.get(name);
		textComp.setText(text);
	}
	catch(ClassCastException cce){
		cce.printStackTrace();
	}
}
	
	public void setSelected(String name, boolean status){
		try{
    AbstractButton buttonComp = (AbstractButton) compMap.get(name);
    buttonComp.setSelected(status);
		}
		catch(ClassCastException cce){
			cce.printStackTrace();
		}
	}

	public void showButton(String name,boolean status){
		try{
			AbstractButton buttonComp = (AbstractButton) compMap.get(name);
      buttonComp.setVisible(status);
		}
		catch(ClassCastException cce){
			cce.printStackTrace();
		}
	}

	public void buildSafariDestination(){
		String location = textFieldLocation.getText();
		String equipmentReq = equipmentTextArea.getText();
		int maxParticipants = checkMaxParticipants(textFieldParticipants.getText());
		String guide = guideBox.getSelectedItem().toString();
		String terrain = checkTerrain();
		int status = checkStatus();

		destination = new SafariDestination(location,equipmentReq,maxParticipants,guide,terrain,status);
	}
	public SafariDestination getSafariDestination(){
		return destination;
	}

	/**
	*Methods to check user input and translate for Objectcreation
	*
	*/
	public int checkMaxParticipants(String input){
    int maxParticipants = 0;
    try{
    maxParticipants = Integer.parseInt(input);
	}
	catch(NumberFormatException nfe){
		nfe.printStackTrace(); // input verification needed...
	}
	return maxParticipants;
}

	public int checkStatus(){
		if(activeButton.isSelected()){
			return 1;
		}
		else{
			return 0;
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

	/**
	*Method to populate textfield according to Object fetched from storage
	*/
	public void populateSafariDestination(SafariDestination destination){
     textFieldLocation.setText(destination.getLocation());
     equipmentTextArea.setText(destination.getEquipmentReq());
     textFieldParticipants.setText(""+destination.getMaxParticipants()+"");
     guideBox.setSelectedItem(destination.getGuide());
     fillTerrain(destination.getTerrain());
     setActive(destination.getStatus());


	}

	
		
	/**
	* Methods to populate components when clicking select
	*/
	public void fillGuideBox(ArrayList<String> array){
	    for(int i = 0; i<array.size(); i++){
		guideBox.addItem(array.get(i));
		}
	}
	public void fillTerrain(String terrain){
		ArrayList<String> array = new ArrayList<String>();
		Scanner parser = new Scanner(terrain).useDelimiter(";");
		while(parser.hasNext()){
			array.add(parser.next());
		}
		for(int i = 0; i<array.size(); i++){
		    System.out.println(array.get(i)); // testutskrift
		    if(array.get(i).equals("Terrain 1")){
         terrain1.setSelected(true);
			}
		    else if(array.get(i).equals("Terrain 2")){
				terrain2.setSelected(true);
			}
		    else if(array.get(i).equals("Terrain 3")){
				terrain3.setSelected(true);
			} else {
			    System.out.println("FAtTAR NADAccZz");
			}
		}
	}

	public void setActive(int status){
		System.out.println(status);
		if(status==1){
			activeButton.setSelected(true);
		}
		else{
			inactiveButton.setSelected(true);
		}
	}



/**
* Methods to clear selections
*/
	public void clearTerrain(){
		for(JCheckBox c : terrains){
       c.setSelected(false);
		}
	}
	public void clearSelection(){
		textFieldLocation.setText("");
		textFieldLocation.setEnabled(true);
		textFieldParticipants.setText("");
		clearTerrain();
		destination = null;

		//clear statusselection too




	}
}
