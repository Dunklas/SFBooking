import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
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

public class SafariDestinationView extends JPanel {
	private JTextField textFieldNamn;
	private JTextField textFieldPlats;

	/**
	 * Create the panel.
	 */
	public SafariDestinationView() {
		setBackground(new Color(204, 204, 204));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{443, 0};
		gridBagLayout.rowHeights = new int[]{16, 22, 16, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNamn = new JLabel("Namn");
		GridBagConstraints gbc_lblNamn = new GridBagConstraints();
		gbc_lblNamn.anchor = GridBagConstraints.NORTH;
		gbc_lblNamn.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNamn.insets = new Insets(0, 0, 5, 0);
		gbc_lblNamn.gridx = 0;
		gbc_lblNamn.gridy = 0;
		add(lblNamn, gbc_lblNamn);
		
		textFieldNamn = new JTextField();
		textFieldNamn.setMinimumSize(new Dimension(100,20));
		GridBagConstraints gbc_textFieldNamn = new GridBagConstraints();
		gbc_textFieldNamn.ipadx = 99;
		gbc_textFieldNamn.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldNamn.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNamn.gridx = 0;
		gbc_textFieldNamn.gridy = 1;
		add(textFieldNamn, gbc_textFieldNamn);
		textFieldNamn.setColumns(10);
		
		JLabel lblPlats = new JLabel("Plats");
		GridBagConstraints gbc_lblPlats = new GridBagConstraints();
		gbc_lblPlats.anchor = GridBagConstraints.NORTH;
		gbc_lblPlats.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPlats.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlats.gridx = 0;
		gbc_lblPlats.gridy = 2;
		add(lblPlats, gbc_lblPlats);
		
		textFieldPlats = new JTextField();
		textFieldPlats.setMinimumSize(new Dimension(100,20));
		GridBagConstraints gbc_textFieldPlats = new GridBagConstraints();
		gbc_textFieldPlats.ipadx = 99;
		gbc_textFieldPlats.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlats.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldPlats.gridx = 0;
		gbc_textFieldPlats.gridy = 3;
		add(textFieldPlats, gbc_textFieldPlats);
		textFieldPlats.setColumns(10);
		
		JLabel lblTerrngtyp = new JLabel("Terr\u00E4ngtyp");
		GridBagConstraints gbc_lblTerrngtyp = new GridBagConstraints();
		gbc_lblTerrngtyp.anchor = GridBagConstraints.WEST;
		gbc_lblTerrngtyp.insets = new Insets(0, 0, 5, 0);
		gbc_lblTerrngtyp.gridx = 0;
		gbc_lblTerrngtyp.gridy = 4;
		add(lblTerrngtyp, gbc_lblTerrngtyp);
		
		JPanel terrainPanel = new JPanel();
		terrainPanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_terrainPanel = new GridBagConstraints();
		gbc_terrainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_terrainPanel.ipady = 15;
		gbc_terrainPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_terrainPanel.gridx = 0;
		gbc_terrainPanel.gridy = 5;
		add(terrainPanel, gbc_terrainPanel);
		terrainPanel.setLayout(new BoxLayout(terrainPanel, BoxLayout.X_AXIS));
		
		JCheckBox chckbxTerrng = new JCheckBox("Terr\u00E4ng 1");
		terrainPanel.add(chckbxTerrng);
		
		JCheckBox chckbxTerrng_1 = new JCheckBox("Terr\u00E4ng 2");
		terrainPanel.add(chckbxTerrng_1);
		
		JCheckBox chckbxTerrng_2 = new JCheckBox("Terr\u00E4ng 3");
		terrainPanel.add(chckbxTerrng_2);
		
		JLabel lblAnsvarigGuide = new JLabel("Ansvarig guide");
		GridBagConstraints gbc_lblAnsvarigGuide = new GridBagConstraints();
		gbc_lblAnsvarigGuide.anchor = GridBagConstraints.WEST;
		gbc_lblAnsvarigGuide.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnsvarigGuide.gridx = 0;
		gbc_lblAnsvarigGuide.gridy = 6;
		add(lblAnsvarigGuide, gbc_lblAnsvarigGuide);
		
		JPanel guidePanel = new JPanel();
		guidePanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_guidePanel = new GridBagConstraints();
		gbc_guidePanel.insets = new Insets(0, 0, 5, 0);
		gbc_guidePanel.ipady = 15;
		gbc_guidePanel.anchor = GridBagConstraints.NORTH;
		gbc_guidePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_guidePanel.gridx = 0;
		gbc_guidePanel.gridy = 7;
		add(guidePanel, gbc_guidePanel);
		guidePanel.setLayout(new BoxLayout(guidePanel, BoxLayout.X_AXIS));
		
		JComboBox guideBox = new JComboBox();
		guideBox.setMaximumSize(new Dimension(200, 25));
		guidePanel.add(guideBox);
		
		JLabel lblUtrustning = new JLabel("Utrustning");
		GridBagConstraints gbc_lblUtrustning = new GridBagConstraints();
		gbc_lblUtrustning.anchor = GridBagConstraints.WEST;
		gbc_lblUtrustning.insets = new Insets(0, 0, 5, 0);
		gbc_lblUtrustning.gridx = 0;
		gbc_lblUtrustning.gridy = 8;
		add(lblUtrustning, gbc_lblUtrustning);
		
		JPanel gearPanel = new JPanel();
		gearPanel.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_gearPanel = new GridBagConstraints();
		gbc_gearPanel.insets = new Insets(0, 0, 5, 0);
		gbc_gearPanel.ipady = 99;
		gbc_gearPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_gearPanel.gridx = 0;
		gbc_gearPanel.gridy = 9;
		add(gearPanel, gbc_gearPanel);
		gearPanel.setLayout(new BoxLayout(gearPanel, BoxLayout.X_AXIS));
		
		JScrollPane availableGearScrollPane = new JScrollPane();
		availableGearScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearPanel.add(availableGearScrollPane);
		
		JList availableGearList = new JList();
		availableGearScrollPane.setViewportView(availableGearList);
		
		JPanel gearButtonPanel = new JPanel();
		gearPanel.add(gearButtonPanel);
		gearButtonPanel.setLayout(new BoxLayout(gearButtonPanel, BoxLayout.Y_AXIS));
		
		JButton addGearButton = new JButton("L\u00E4gg till >>");
		gearButtonPanel.add(addGearButton);
		
		JButton removeGearButton = new JButton("<< Ta bort");
		removeGearButton.setMaximumSize(new Dimension(105, 25));
		gearButtonPanel.add(removeGearButton);
		
		JScrollPane addedGearScrollPane = new JScrollPane();
		addedGearScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gearPanel.add(addedGearScrollPane);
		
		JList addedGearList = new JList();
		addedGearScrollPane.setViewportView(addedGearList);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(new Color(204, 204, 204));
		ButtonGroup statusGroup = new ButtonGroup();
		
		
		GridBagConstraints gbc_statusPanel = new GridBagConstraints();
		gbc_statusPanel.ipady = 15;
		gbc_statusPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_statusPanel.insets = new Insets(0, 0, 5, 0);
		gbc_statusPanel.gridx = 0;
		gbc_statusPanel.gridy = 10;
		add(statusPanel, gbc_statusPanel);
		
		JRadioButton activeButton = new JRadioButton("Bokningsbar");
		activeButton.setVisible(false);
		statusPanel.add(activeButton);
		
		JRadioButton inactiveButton = new JRadioButton("Ej bokningsbar");
		inactiveButton.setVisible(false);
		statusPanel.add(inactiveButton);
		
		statusGroup.add(activeButton); statusGroup.add(inactiveButton);
		
		JButton saveNewSafariButton = new JButton("Save");
		saveNewSafariButton.setMinimumSize(new Dimension(100, 25));
		GridBagConstraints gbc_saveNewSafariButton = new GridBagConstraints();
		gbc_saveNewSafariButton.anchor = GridBagConstraints.WEST;
		gbc_saveNewSafariButton.gridx = 0;
		gbc_saveNewSafariButton.gridy = 11;
		add(saveNewSafariButton, gbc_saveNewSafariButton);

	}

}
