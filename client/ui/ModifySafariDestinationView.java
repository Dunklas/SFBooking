package client.ui;

import java.util.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.*;

public class ModifySafariDestinationView extends JPanel {

	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private HashMap<String,Component> compMap = new HashMap<String,Component>();
	JList<String> modifyList;
	
	public ModifySafariDestinationView() {
		setPreferredSize(new Dimension(452, 641));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 400, 0};
		gridBagLayout.rowHeights = new int[]{392, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane modifyListScrollPane = new JScrollPane();
		modifyListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_modifyListScrollPane = new GridBagConstraints();
		gbc_modifyListScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_modifyListScrollPane.fill = GridBagConstraints.BOTH;
		gbc_modifyListScrollPane.gridx = 1;
		gbc_modifyListScrollPane.gridy = 0;
		add(modifyListScrollPane, gbc_modifyListScrollPane);
		
		
		modifyList = new JList(listModel);
		modifyList.setName("modifyList");
		
		modifyListScrollPane.setViewportView(modifyList);
		
		JPanel modifyButtonPanel = new JPanel();
		GridBagConstraints gbc_modifyButtonPanel = new GridBagConstraints();
		gbc_modifyButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_modifyButtonPanel.gridx = 1;
		gbc_modifyButtonPanel.gridy = 1;
		add(modifyButtonPanel, gbc_modifyButtonPanel);
		modifyButtonPanel.setLayout(new BoxLayout(modifyButtonPanel, BoxLayout.Y_AXIS));
		
		JButton selectButton = new JButton("V\u00E4lj");
		selectButton.setName("selectButton");
		selectButton.setMaximumSize(new Dimension(125, 25));
		selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		modifyButtonPanel.add(selectButton);

		initCompMap();
	}
	public void fillList(DefaultListModel<String> model){
		modifyList.setModel(model);
	}
	public void initCompMap(){
		Component[] compArray = this.getComponents();
		for(int i=0; i<compArray.length; i++){
			compMap.put(compArray[i].getName(),compArray[i]);
		}
	}
	public HashMap<String,Component> getCompMap(){
		return compMap;
	}

}
