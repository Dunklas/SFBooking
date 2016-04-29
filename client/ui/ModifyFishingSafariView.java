package client.ui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.ScrollPane;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.Box;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

public class ModifyFishingSafariView extends JPanel {

	HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();
	ArrayList<JComponent> compArray = new ArrayList<JComponent>();

	DefaultListModel<String> placeholderModel = new DefaultListModel<String>();
	JList<String> modifyList;
	
	public ModifyFishingSafariView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 383, 0};
		gbl_panel.rowHeights = new int[]{44, 378, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane modifyListScrollPane = new JScrollPane();
		modifyListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_modifyListScrollPane = new GridBagConstraints();
		gbc_modifyListScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_modifyListScrollPane.fill = GridBagConstraints.BOTH;
		gbc_modifyListScrollPane.gridx = 1;
		gbc_modifyListScrollPane.gridy = 1;
		panel.add(modifyListScrollPane, gbc_modifyListScrollPane);
		
		modifyList = new JList<String>();
		compArray.add(modifyList);
		modifyList.setName("modifyList");
		modifyListScrollPane.setViewportView(modifyList);
		
		JPanel modifyButtonPanel = new JPanel();
		GridBagConstraints gbc_modifyButtonPanel = new GridBagConstraints();
		gbc_modifyButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_modifyButtonPanel.gridx = 1;
		gbc_modifyButtonPanel.gridy = 2;
		panel.add(modifyButtonPanel, gbc_modifyButtonPanel);
		modifyButtonPanel.setLayout(new BoxLayout(modifyButtonPanel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnDennaVecka = new JRadioButton("Denna vecka");
		compArray.add(rdbtnDennaVecka);
		rdbtnDennaVecka.setName("thisWeek");
		modifyButtonPanel.add(rdbtnDennaVecka);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut);
		
		JRadioButton rdbtnDennaMnad = new JRadioButton("Denna m\u00E5nad");
		compArray.add(rdbtnDennaMnad);
		rdbtnDennaMnad.setName("thisMonth");
		modifyButtonPanel.add(rdbtnDennaMnad);
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut_1);
		
		JRadioButton rdbtnDettar = new JRadioButton("Detta \u00E5r");
		compArray.add(rdbtnDettar);
		rdbtnDettar.setName("thisYear");
		modifyButtonPanel.add(rdbtnDettar);
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		compArray.add(comboBox);
		comboBox.setName("comboBox");
		comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBox.setMaximumSize(new Dimension(150, 25));
		modifyButtonPanel.add(comboBox);
		
		Component verticalStrut_3 = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut_3);
		
		JButton selectButton = new JButton("Select");
		modifyButtonPanel.add(selectButton);
		selectButton.setName("selectButton");
		compArray.add(selectButton);
		
		initCompMap();

	}
	public void initCompMap(){
		for(JComponent comp : compArray){
			compMap.put(comp.getName(),comp);
		}
	}
	public HashMap<String,JComponent> getCompMap(){
		return compMap;
	}

	public void fillList(ArrayList<String> array){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(String s : array){
			listModel.addElement(s);
		}
      modifyList.setModel(listModel);
	}
	public int getSelectedFishingSafari(){
		Scanner parser = new Scanner(modifyList.getSelectedValue()).useDelimiter(";");
		int fishingSafariID = 0;
    try{
    fishingSafariID = Integer.parseInt(parser.next());
	}
	catch (NumberFormatException e){
     e.printStackTrace();
	}
	return fishingSafariID;
}

}
