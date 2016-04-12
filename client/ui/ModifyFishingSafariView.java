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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel radioButtonPanel = new JPanel();
		GridBagConstraints gbc_radioButtonPanel = new GridBagConstraints();
		gbc_radioButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_radioButtonPanel.gridx = 1;
		gbc_radioButtonPanel.gridy = 2;
		panel.add(radioButtonPanel, gbc_radioButtonPanel);
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnDennaVecka = new JRadioButton("Denna vecka");
		radioButtonPanel.add(rdbtnDennaVecka);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		radioButtonPanel.add(verticalStrut);
		
		JRadioButton rdbtnDennaMnad = new JRadioButton("Denna m\u00E5nad");
		radioButtonPanel.add(rdbtnDennaMnad);
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		radioButtonPanel.add(verticalStrut_1);
		
		JRadioButton rdbtnDettar = new JRadioButton("Detta \u00E5r");
		radioButtonPanel.add(rdbtnDettar);
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		radioButtonPanel.add(verticalStrut_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		comboBox.setMaximumSize(new Dimension(150, 25));
		radioButtonPanel.add(comboBox);
		
		

	}

}
