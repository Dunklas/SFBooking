import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.ButtonGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class AddBookingView extends JPanel {
	private JTextField startDate;
	private JTextField endDate;
	private JTextField destination;
	private JTextField startTime;
	private JTextField endTime;
	private JTextField customerEmail;
	private JTextField customerFirstName;
	private JTextField customerLastName;
	private JTextField customerPhoneNumber;

  private ArrayList<JComponent> compArray = new ArrayList<JComponent>();
  private HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();

	
	public AddBookingView() {
		setMaximumSize(new Dimension(1000, 1000));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{171, 0, 0};
		gridBagLayout.rowHeights = new int[]{601, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel leftPanel = new JPanel();
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.insets = new Insets(0, 0, 5, 5);
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		add(leftPanel, gbc_leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(10);
		leftPanel.add(verticalStrut);
		
		JLabel pickSafariLabel = new JLabel("V\u00E4lj en fiskesafari");
		pickSafariLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(pickSafariLabel);
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		leftPanel.add(listScrollPane);
		
		JList fishingSafariList = new JList();
		listScrollPane.setViewportView(fishingSafariList);

    ButtonGroup bg = new ButtonGroup();
		
		JRadioButton weekButton = new JRadioButton("Denna vecka");
    bg.add(weekButton);
		leftPanel.add(weekButton);
		
		JRadioButton monthButton = new JRadioButton("Denna m\u00E5nad");
    bg.add(monthButton);
		leftPanel.add(monthButton);
		
		JRadioButton yearButton = new JRadioButton("Detta \u00E5r");
    bg.add(yearButton);
		leftPanel.add(yearButton);
		
		JComboBox destinationPicker = new JComboBox();
		destinationPicker.setAlignmentX(Component.LEFT_ALIGNMENT);
		destinationPicker.setMaximumSize(new Dimension(200, 25));
		leftPanel.add(destinationPicker);
		
		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 1;
		gbc_mainPanel.gridy = 0;
		add(mainPanel, gbc_mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{519, 0};
		gbl_mainPanel.rowHeights = new int[]{281, 251, 0, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JPanel topLabelPanel = new JPanel();
		GridBagConstraints gbc_topLabelPanel = new GridBagConstraints();
		gbc_topLabelPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topLabelPanel.fill = GridBagConstraints.BOTH;
		gbc_topLabelPanel.gridx = 0;
		gbc_topLabelPanel.gridy = 0;
		mainPanel.add(topLabelPanel, gbc_topLabelPanel);
		topLabelPanel.setLayout(new BoxLayout(topLabelPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		topLabelPanel.add(verticalStrut_1);
		
		JLabel infoTopLabel = new JLabel("Uppgifter om vald fiskesafari:");
		infoTopLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		infoTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		topLabelPanel.add(infoTopLabel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		topLabelPanel.add(verticalStrut_2);
		
		JPanel fishingSafariPanel = new JPanel();
		topLabelPanel.add(fishingSafariPanel);
		fishingSafariPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel fsLeftPanel = new JPanel();
		fishingSafariPanel.add(fsLeftPanel);
		fsLeftPanel.setLayout(new BoxLayout(fsLeftPanel, BoxLayout.Y_AXIS));
		
		JLabel lblStartdatum = new JLabel("Startdatum");
		lblStartdatum.setAlignmentX(0.2f);
		fsLeftPanel.add(lblStartdatum);
		
		startDate = new JTextField();
		startDate.setAlignmentX(0.1f);
		startDate.setMaximumSize(new Dimension(200, 25));
		fsLeftPanel.add(startDate);
		startDate.setColumns(10);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		fsLeftPanel.add(verticalStrut_3);
		
		JLabel lblSlutdatum = new JLabel("Slutdatum");
		lblSlutdatum.setAlignmentX(0.2f);
		fsLeftPanel.add(lblSlutdatum);
		
		endDate = new JTextField();
		endDate.setAlignmentX(0.1f);
		endDate.setMaximumSize(new Dimension(200, 25));
		fsLeftPanel.add(endDate);
		endDate.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		fsLeftPanel.add(verticalStrut_4);
		
		JLabel lblSafariml = new JLabel("Safarim\u00E5l");
		lblSafariml.setAlignmentX(0.2f);
		fsLeftPanel.add(lblSafariml);
		
		destination = new JTextField();
		destination.setAlignmentX(0.1f);
		destination.setMaximumSize(new Dimension(200, 25));
		fsLeftPanel.add(destination);
		destination.setColumns(10);
		
		JPanel fsMiddlePanel = new JPanel();
		fishingSafariPanel.add(fsMiddlePanel);
		fsMiddlePanel.setLayout(new BoxLayout(fsMiddlePanel, BoxLayout.Y_AXIS));
		
		JLabel lblStarttid = new JLabel("Starttid");
		lblStarttid.setAlignmentX(0.2f);
		fsMiddlePanel.add(lblStarttid);
		
		startTime = new JTextField();
		startTime.setAlignmentX(0.1f);
		startTime.setMaximumSize(new Dimension(200, 25));
		fsMiddlePanel.add(startTime);
		startTime.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		fsMiddlePanel.add(verticalStrut_5);
		
		JLabel lblSluttid = new JLabel("Sluttid");
		lblSluttid.setAlignmentX(0.2f);
		fsMiddlePanel.add(lblSluttid);
		
		endTime = new JTextField();
		endTime.setMaximumSize(new Dimension(200, 25));
		endTime.setAlignmentX(0.1f);
		fsMiddlePanel.add(endTime);
		endTime.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		fsMiddlePanel.add(verticalStrut_6);
		
		JLabel lblUtrustningskrav = new JLabel("Utrustningskrav");
		lblUtrustningskrav.setAlignmentX(0.2f);
		fsMiddlePanel.add(lblUtrustningskrav);
		
		JTextArea equipmentReqTextArea = new JTextArea();
		equipmentReqTextArea.setMaximumSize(new Dimension(200, 100));
		equipmentReqTextArea.setAlignmentX(0.1f);
		fsMiddlePanel.add(equipmentReqTextArea);
		
		JPanel fsRightPanel = new JPanel();
		fishingSafariPanel.add(fsRightPanel);
		fsRightPanel.setLayout(new BoxLayout(fsRightPanel, BoxLayout.Y_AXIS));
		
		JLabel lblKommentar = new JLabel("Kommentar");
		lblKommentar.setAlignmentX(0.2f);
		fsRightPanel.add(lblKommentar);
		
		JTextArea commentTextArea = new JTextArea();
		commentTextArea.setMaximumSize(new Dimension(200, 100));
		commentTextArea.setAlignmentX(0.1f);
		fsRightPanel.add(commentTextArea);
		
		JPanel centerMainPanel = new JPanel();
		GridBagConstraints gbc_centerMainPanel = new GridBagConstraints();
		gbc_centerMainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_centerMainPanel.fill = GridBagConstraints.BOTH;
		gbc_centerMainPanel.gridx = 0;
		gbc_centerMainPanel.gridy = 1;
		mainPanel.add(centerMainPanel, gbc_centerMainPanel);
		GridBagLayout gbl_centerMainPanel = new GridBagLayout();
		gbl_centerMainPanel.columnWidths = new int[]{264, 0, 0};
		gbl_centerMainPanel.rowHeights = new int[]{0, 0};
		gbl_centerMainPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerMainPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		centerMainPanel.setLayout(gbl_centerMainPanel);
		
		JPanel customerInputPanel = new JPanel();
		GridBagConstraints gbc_customerInputPanel = new GridBagConstraints();
		gbc_customerInputPanel.insets = new Insets(0, 0, 0, 5);
		gbc_customerInputPanel.fill = GridBagConstraints.BOTH;
		gbc_customerInputPanel.gridx = 0;
		gbc_customerInputPanel.gridy = 0;
		centerMainPanel.add(customerInputPanel, gbc_customerInputPanel);
		customerInputPanel.setLayout(new BoxLayout(customerInputPanel, BoxLayout.Y_AXIS));
		
		JLabel lblKunduppgifter = new JLabel("Kunduppgifter:");
		lblKunduppgifter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKunduppgifter.setAlignmentX(0.2f);
		customerInputPanel.add(lblKunduppgifter);
		
		Component verticalStrut_7 = Box.createVerticalStrut(7);
		customerInputPanel.add(verticalStrut_7);
		
		JLabel lblNamn = new JLabel("Email");
		lblNamn.setAlignmentX(0.2f);
		customerInputPanel.add(lblNamn);
		
		customerEmail = new JTextField();
		customerEmail.setMaximumSize(new Dimension(200, 25));
		customerEmail.setAlignmentX(0.1f);
		customerInputPanel.add(customerEmail);
		customerEmail.setColumns(10);
		
		Component verticalStrut_8 = Box.createVerticalStrut(8);
		customerInputPanel.add(verticalStrut_8);
		
		JLabel lblNamn_1 = new JLabel("F\u00F6rnamn");
		lblNamn_1.setAlignmentX(0.2f);
		customerInputPanel.add(lblNamn_1);
		
		customerFirstName = new JTextField();
		customerFirstName.setMaximumSize(new Dimension(200, 25));
		customerFirstName.setAlignmentX(0.1f);
		customerInputPanel.add(customerFirstName);
		customerFirstName.setColumns(10);
		
		Component verticalStrut_9 = Box.createVerticalStrut(8);
		customerInputPanel.add(verticalStrut_9);
		
		JLabel lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setAlignmentX(0.2f);
		customerInputPanel.add(lblEfternamn);
		
		customerLastName = new JTextField();
		customerLastName.setMaximumSize(new Dimension(200, 25));
		customerLastName.setAlignmentX(0.1f);
		customerInputPanel.add(customerLastName);
		customerLastName.setColumns(10);
		
		Component verticalStrut_10 = Box.createVerticalStrut(8);
		customerInputPanel.add(verticalStrut_10);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer");
		lblTelefonnummer.setAlignmentX(0.2f);
		customerInputPanel.add(lblTelefonnummer);
		
		customerPhoneNumber = new JTextField();
		customerPhoneNumber.setMaximumSize(new Dimension(200, 25));
		customerPhoneNumber.setAlignmentX(0.1f);
		customerInputPanel.add(customerPhoneNumber);
		customerPhoneNumber.setColumns(10);
		
		JPanel equipmentPanel = new JPanel();
		GridBagConstraints gbc_equipmentPanel = new GridBagConstraints();
		gbc_equipmentPanel.fill = GridBagConstraints.BOTH;
		gbc_equipmentPanel.gridx = 1;
		gbc_equipmentPanel.gridy = 0;
		centerMainPanel.add(equipmentPanel, gbc_equipmentPanel);
		equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS));
		
		JLabel lblHyrUtrustningvalfritt = new JLabel("Hyr utrustning (valfritt) :");
		lblHyrUtrustningvalfritt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblHyrUtrustningvalfritt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		equipmentPanel.add(lblHyrUtrustningvalfritt);
		
		Component verticalStrut_11 = Box.createVerticalStrut(8);
		equipmentPanel.add(verticalStrut_11);
		
		JPanel equipmentListPanel = new JPanel();
		equipmentPanel.add(equipmentListPanel);
		GridBagLayout gbl_equipmentListPanel = new GridBagLayout();
		gbl_equipmentListPanel.columnWidths = new int[]{250, 63, 250, 0};
		gbl_equipmentListPanel.rowHeights = new int[]{0, 0};
		gbl_equipmentListPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_equipmentListPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		equipmentListPanel.setLayout(gbl_equipmentListPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		equipmentListPanel.add(scrollPane, gbc_scrollPane);
		
		JList availableEquipmentList = new JList();
		scrollPane.setViewportView(availableEquipmentList);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		equipmentListPanel.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_12 = Box.createVerticalStrut(70);
		panel.add(verticalStrut_12);
		
		JButton rentButton = new JButton("Hyr >>");
		rentButton.setMaximumSize(new Dimension(109, 25));
		rentButton.setPreferredSize(new Dimension(109, 25));
		panel.add(rentButton);
		
		JButton regretButton = new JButton("<< \u00C5ngra val");
		panel.add(regretButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 0;
		equipmentListPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		JList rentedEquipmentList = new JList();
		scrollPane_1.setViewportView(rentedEquipmentList);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 2;
		mainPanel.add(buttonPanel, gbc_buttonPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		buttonPanel.add(horizontalStrut);
		
		JButton saveButton = new JButton("Spara");
		buttonPanel.add(saveButton);
		
		JButton clearButton = new JButton("Rensa");
		buttonPanel.add(clearButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(400);
		buttonPanel.add(horizontalStrut_1);
		
		JButton cancelButton = new JButton("Avbryt");
		buttonPanel.add(cancelButton);
		
		JButton backButton = new JButton("Tillbaka");
		buttonPanel.add(backButton);
		

	}

}
