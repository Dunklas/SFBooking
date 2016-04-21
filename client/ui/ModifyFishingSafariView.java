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

public class ModifyFishingSafariView extends JPanel {

	HashMap<String,Component> compMap = new HashMap<String,Component>();
	ArrayList<Component> compArray = new ArrayList<Component>();

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
		
		initCompMap();

	}
	public void initCompMap(){
		for(int i=0; i<compArray.size(); i++){
			compMap.put(compArray.get(i).getName(),compArray.get(i));
		}
	}
	public HashMap<String,Component> getCompMap(){
		return compMap;
	}

	public void fillList(DefaultListModel<String> listModel){
      modifyList.setModel(listModel);
	}

}
