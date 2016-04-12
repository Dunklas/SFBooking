//package client.ui;

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

public class ModifyFishingSafariView extends JPanel {

	/**
	 * Create the panel.
	 */
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
		
		JList modifyList = new JList();
		modifyListScrollPane.setViewportView(modifyList);
		
		JPanel modifyButtonPanel = new JPanel();
		GridBagConstraints gbc_modifyButtonPanel = new GridBagConstraints();
		gbc_modifyButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_modifyButtonPanel.gridx = 1;
		gbc_modifyButtonPanel.gridy = 2;
		panel.add(modifyButtonPanel, gbc_modifyButtonPanel);
		modifyButtonPanel.setLayout(new BoxLayout(modifyButtonPanel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnDennaVecka = new JRadioButton("Denna vecka");
		modifyButtonPanel.add(rdbtnDennaVecka);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut);
		
		JRadioButton rdbtnDennaMnad = new JRadioButton("Denna m\u00E5nad");
		modifyButtonPanel.add(rdbtnDennaMnad);
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut_1);
		
		JRadioButton rdbtnDettar = new JRadioButton("Detta \u00E5r");
		modifyButtonPanel.add(rdbtnDettar);
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		modifyButtonPanel.add(verticalStrut_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBox.setMaximumSize(new Dimension(150, 25));
		modifyButtonPanel.add(comboBox);
		
		

	}

}
