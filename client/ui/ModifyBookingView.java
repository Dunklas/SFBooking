import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;

public class ModifyBookingView extends JPanel {
	private JTextField searchEmail;
	private JTextField searchSafari;
	private JTextField bookingNumberField;
	private JTextField bookingDateField;
	private JTextField prelConfirmField;
	private JTextField paymentField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField customerNumberField;
	private JTextField customerFirstNameField;
	private JTextField customerLastNameField;
	private JTextField customerEmailField;
	private JTextField customerPhoneNumberField;
	private JTextField startDateField;
	private JTextField endDateField;
	private JTextField destinationField;
	private JTextField startTimeField;
	private JTextField endTimeField;

	private ArrayList<JComponent> compArray = new ArrayList<JComponent>();
	private HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();

	/**
	 * Create the panel.
	 */
	public ModifyBookingView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{171, 0, 0};
		gridBagLayout.rowHeights = new int[]{605, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel leftPanel = new JPanel();
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		add(leftPanel, gbc_leftPanel);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		JLabel lblVljEnBokning = new JLabel("V\u00E4lj en bokning:");
		lblVljEnBokning.setAlignmentX(0.2f);
		lblVljEnBokning.setFont(new Font("Tahoma", Font.PLAIN, 20));
		leftPanel.add(lblVljEnBokning);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		leftPanel.add(verticalStrut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(32767, 300));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		leftPanel.add(scrollPane);
		
		JList bookingList = new JList();
		scrollPane.setViewportView(bookingList);
		
		Component verticalStrut_10 = Box.createVerticalStrut(20);
		leftPanel.add(verticalStrut_10);
		
		JLabel lblSkEfterBokning = new JLabel("S\u00F6k efter email");
		lblSkEfterBokning.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(lblSkEfterBokning);
		
		searchEmail = new JTextField();
		searchEmail.setMaximumSize(new Dimension(225, 25));
		leftPanel.add(searchEmail);
		searchEmail.setColumns(10);
		
		JLabel lblSkEfterFiskesafari = new JLabel("S\u00F6k efter fiskesafari");
		lblSkEfterFiskesafari.setAlignmentX(0.4f);
		leftPanel.add(lblSkEfterFiskesafari);
		
		searchSafari = new JTextField();
		searchSafari.setMaximumSize(new Dimension(225, 25));
		leftPanel.add(searchSafari);
		searchSafari.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		leftPanel.add(verticalStrut_1);
		
		JButton searchButton = new JButton("S\u00F6k");
		searchButton.setName("searchButton");
		compArray.add(searchButton);
		searchButton.setMaximumSize(new Dimension(100, 25));
		searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(searchButton);
		
		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 1;
		gbc_mainPanel.gridy = 0;
		add(mainPanel, gbc_mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{905, 0};
		gbl_mainPanel.rowHeights = new int[]{209, 193, 190, 155, 66, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JPanel bookingInfoPanel = new JPanel();
		GridBagConstraints gbc_bookingInfoPanel = new GridBagConstraints();
		gbc_bookingInfoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_bookingInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_bookingInfoPanel.gridx = 0;
		gbc_bookingInfoPanel.gridy = 0;
		mainPanel.add(bookingInfoPanel, gbc_bookingInfoPanel);
		bookingInfoPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftBookingInfoPanel = new JPanel();
		bookingInfoPanel.add(leftBookingInfoPanel);
		leftBookingInfoPanel.setLayout(new BoxLayout(leftBookingInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		leftBookingInfoPanel.add(verticalStrut_2);
		
		JLabel lblNewLabel = new JLabel("Bokningsnummer");
		lblNewLabel.setAlignmentX(0.2f);
		leftBookingInfoPanel.add(lblNewLabel);
		
		bookingNumberField = new JTextField();
		bookingNumberField.setAlignmentX(0.1f);
		bookingNumberField.setMaximumSize(new Dimension(350, 25));
		leftBookingInfoPanel.add(bookingNumberField);
		bookingNumberField.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(5);
		leftBookingInfoPanel.add(verticalStrut_4);
		
		JLabel lblBokningsdatum = new JLabel("Bokningsdatum");
		lblBokningsdatum.setAlignmentX(0.2f);
		leftBookingInfoPanel.add(lblBokningsdatum);
		
		bookingDateField = new JTextField();
		bookingDateField.setAlignmentX(0.1f);
		bookingDateField.setMaximumSize(new Dimension(350, 25));
		leftBookingInfoPanel.add(bookingDateField);
		bookingDateField.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(5);
		leftBookingInfoPanel.add(verticalStrut_5);
		
		JLabel lblPreliminrBekrftelseSkickad = new JLabel("Prelimin\u00E4r bekr\u00E4ftelse skickad");
		lblPreliminrBekrftelseSkickad.setAlignmentX(0.2f);
		leftBookingInfoPanel.add(lblPreliminrBekrftelseSkickad);
		
		prelConfirmField = new JTextField();
		prelConfirmField.setAlignmentX(0.1f);
		prelConfirmField.setMaximumSize(new Dimension(350, 25));
		leftBookingInfoPanel.add(prelConfirmField);
		prelConfirmField.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(5);
		leftBookingInfoPanel.add(verticalStrut_6);
		
		JLabel lblBetalningsdatum = new JLabel("Betalningsdatum");
		lblBetalningsdatum.setAlignmentX(0.2f);
		leftBookingInfoPanel.add(lblBetalningsdatum);
		
		paymentField = new JTextField();
		paymentField.setAlignmentX(0.1f);
		paymentField.setMaximumSize(new Dimension(350, 25));
		leftBookingInfoPanel.add(paymentField);
		paymentField.setColumns(10);
		
		JPanel rightBookingInfoPanel = new JPanel();
		bookingInfoPanel.add(rightBookingInfoPanel);
		rightBookingInfoPanel.setLayout(new BoxLayout(rightBookingInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_3 = Box.createVerticalStrut(5);
		rightBookingInfoPanel.add(verticalStrut_3);
		
		JLabel lblKostnad = new JLabel("Kostnad");
		lblKostnad.setAlignmentX(0.2f);
		rightBookingInfoPanel.add(lblKostnad);
		
		textField_4 = new JTextField();
		textField_4.setMaximumSize(new Dimension(350, 25));
		textField_4.setAlignmentX(0.1f);
		rightBookingInfoPanel.add(textField_4);
		textField_4.setColumns(10);
		
		Component verticalStrut_7 = Box.createVerticalStrut(5);
		rightBookingInfoPanel.add(verticalStrut_7);
		
		JLabel lblAvbokningsdatum = new JLabel("Avbokningsdatum");
		lblAvbokningsdatum.setAlignmentX(0.2f);
		rightBookingInfoPanel.add(lblAvbokningsdatum);
		
		textField_5 = new JTextField();
		textField_5.setMaximumSize(new Dimension(350, 25));
		textField_5.setAlignmentX(0.1f);
		rightBookingInfoPanel.add(textField_5);
		textField_5.setColumns(10);
		
		Component verticalStrut_8 = Box.createVerticalStrut(5);
		rightBookingInfoPanel.add(verticalStrut_8);
		
		JLabel lblSlutligBekrftelseSkickad = new JLabel("Slutlig bekr\u00E4ftelse skickad");
		lblSlutligBekrftelseSkickad.setAlignmentX(0.2f);
		rightBookingInfoPanel.add(lblSlutligBekrftelseSkickad);
		
		textField_6 = new JTextField();
		textField_6.setMaximumSize(new Dimension(350, 25));
		textField_6.setAlignmentX(0.1f);
		rightBookingInfoPanel.add(textField_6);
		textField_6.setColumns(10);
		
		Component verticalStrut_9 = Box.createVerticalStrut(5);
		rightBookingInfoPanel.add(verticalStrut_9);
		
		JLabel lblFiskesafariGenomfrd = new JLabel("Fiskesafari genomf\u00F6rd");
		lblFiskesafariGenomfrd.setAlignmentX(0.2f);
		rightBookingInfoPanel.add(lblFiskesafariGenomfrd);
		
		textField_7 = new JTextField();
		textField_7.setMaximumSize(new Dimension(350, 25));
		textField_7.setAlignmentX(0.1f);
		rightBookingInfoPanel.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel customerInfoPanel = new JPanel();
		GridBagConstraints gbc_customerInfoPanel = new GridBagConstraints();
		gbc_customerInfoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_customerInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_customerInfoPanel.gridx = 0;
		gbc_customerInfoPanel.gridy = 1;
		mainPanel.add(customerInfoPanel, gbc_customerInfoPanel);
		customerInfoPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftCustomerInfoPanel = new JPanel();
		customerInfoPanel.add(leftCustomerInfoPanel);
		leftCustomerInfoPanel.setLayout(new BoxLayout(leftCustomerInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_11 = Box.createVerticalStrut(20);
		leftCustomerInfoPanel.add(verticalStrut_11);
		
		JLabel lblKundnummer = new JLabel("Kundnummer");
		lblKundnummer.setAlignmentX(0.2f);
		leftCustomerInfoPanel.add(lblKundnummer);
		
		customerNumberField = new JTextField();
		customerNumberField.setMaximumSize(new Dimension(350, 25));
		customerNumberField.setAlignmentX(0.1f);
		leftCustomerInfoPanel.add(customerNumberField);
		customerNumberField.setColumns(10);
		
		Component verticalStrut_13 = Box.createVerticalStrut(5);
		leftCustomerInfoPanel.add(verticalStrut_13);
		
		JLabel lblNewLabel_1 = new JLabel("F\u00F6rnamn");
		lblNewLabel_1.setAlignmentX(0.2f);
		leftCustomerInfoPanel.add(lblNewLabel_1);
		
		customerFirstNameField = new JTextField();
		customerFirstNameField.setMaximumSize(new Dimension(350, 25));
		customerFirstNameField.setAlignmentX(0.1f);
		leftCustomerInfoPanel.add(customerFirstNameField);
		customerFirstNameField.setColumns(10);
		
		Component verticalStrut_14 = Box.createVerticalStrut(5);
		leftCustomerInfoPanel.add(verticalStrut_14);
		
		JLabel lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setAlignmentX(0.2f);
		leftCustomerInfoPanel.add(lblEfternamn);
		
		customerLastNameField = new JTextField();
		customerLastNameField.setMaximumSize(new Dimension(350, 25));
		customerLastNameField.setAlignmentX(0.1f);
		leftCustomerInfoPanel.add(customerLastNameField);
		customerLastNameField.setColumns(10);
		
		JPanel rightCustomerInfoPanel = new JPanel();
		customerInfoPanel.add(rightCustomerInfoPanel);
		rightCustomerInfoPanel.setLayout(new BoxLayout(rightCustomerInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_12 = Box.createVerticalStrut(20);
		rightCustomerInfoPanel.add(verticalStrut_12);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setAlignmentX(0.2f);
		rightCustomerInfoPanel.add(lblEmail);
		
		customerEmailField = new JTextField();
		customerEmailField.setMaximumSize(new Dimension(350, 25));
		customerEmailField.setAlignmentX(0.1f);
		rightCustomerInfoPanel.add(customerEmailField);
		customerEmailField.setColumns(10);
		
		Component verticalStrut_15 = Box.createVerticalStrut(5);
		rightCustomerInfoPanel.add(verticalStrut_15);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnummer");
		lblTelefonnummer.setAlignmentX(0.2f);
		rightCustomerInfoPanel.add(lblTelefonnummer);
		
		customerPhoneNumberField = new JTextField();
		customerPhoneNumberField.setMaximumSize(new Dimension(350, 25));
		customerPhoneNumberField.setAlignmentX(0.1f);
		rightCustomerInfoPanel.add(customerPhoneNumberField);
		customerPhoneNumberField.setColumns(10);
		
		JPanel fishingSafariInfoPanel = new JPanel();
		GridBagConstraints gbc_fishingSafariInfoPanel = new GridBagConstraints();
		gbc_fishingSafariInfoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_fishingSafariInfoPanel.fill = GridBagConstraints.BOTH;
		gbc_fishingSafariInfoPanel.gridx = 0;
		gbc_fishingSafariInfoPanel.gridy = 2;
		mainPanel.add(fishingSafariInfoPanel, gbc_fishingSafariInfoPanel);
		fishingSafariInfoPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftFishingSafariInfoPanel = new JPanel();
		fishingSafariInfoPanel.add(leftFishingSafariInfoPanel);
		leftFishingSafariInfoPanel.setLayout(new BoxLayout(leftFishingSafariInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_16 = Box.createVerticalStrut(20);
		leftFishingSafariInfoPanel.add(verticalStrut_16);
		
		JLabel lblStartdatum = new JLabel("Startdatum");
		lblStartdatum.setAlignmentX(0.2f);
		leftFishingSafariInfoPanel.add(lblStartdatum);
		
		startDateField = new JTextField();
		startDateField.setMaximumSize(new Dimension(350, 25));
		startDateField.setAlignmentX(0.1f);
		leftFishingSafariInfoPanel.add(startDateField);
		startDateField.setColumns(10);
		
		Component verticalStrut_18 = Box.createVerticalStrut(5);
		leftFishingSafariInfoPanel.add(verticalStrut_18);
		
		JLabel lblSlutdatum = new JLabel("Slutdatum");
		lblSlutdatum.setAlignmentX(0.2f);
		leftFishingSafariInfoPanel.add(lblSlutdatum);
		
		endDateField = new JTextField();
		endDateField.setMaximumSize(new Dimension(350, 25));
		endDateField.setAlignmentX(0.1f);
		leftFishingSafariInfoPanel.add(endDateField);
		endDateField.setColumns(10);
		
		Component verticalStrut_19 = Box.createVerticalStrut(5);
		leftFishingSafariInfoPanel.add(verticalStrut_19);
		
		JLabel lblSafariml = new JLabel("Safarim\u00E5l");
		lblSafariml.setAlignmentX(0.2f);
		leftFishingSafariInfoPanel.add(lblSafariml);
		
		destinationField = new JTextField();
		destinationField.setMaximumSize(new Dimension(350, 25));
		destinationField.setAlignmentX(0.1f);
		leftFishingSafariInfoPanel.add(destinationField);
		destinationField.setColumns(10);
		
		JPanel rightFishingSafariInfoPanel = new JPanel();
		fishingSafariInfoPanel.add(rightFishingSafariInfoPanel);
		rightFishingSafariInfoPanel.setLayout(new BoxLayout(rightFishingSafariInfoPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut_17 = Box.createVerticalStrut(20);
		rightFishingSafariInfoPanel.add(verticalStrut_17);
		
		JLabel lblStarttid = new JLabel("Starttid");
		lblStarttid.setAlignmentX(0.2f);
		rightFishingSafariInfoPanel.add(lblStarttid);
		
		startTimeField = new JTextField();
		startTimeField.setMaximumSize(new Dimension(350, 25));
		startTimeField.setAlignmentX(0.1f);
		rightFishingSafariInfoPanel.add(startTimeField);
		startTimeField.setColumns(10);
		
		Component verticalStrut_20 = Box.createVerticalStrut(5);
		rightFishingSafariInfoPanel.add(verticalStrut_20);
		
		JLabel lblSluttid = new JLabel("Sluttid");
		lblSluttid.setAlignmentX(0.2f);
		rightFishingSafariInfoPanel.add(lblSluttid);
		
		endTimeField = new JTextField();
		endTimeField.setMaximumSize(new Dimension(350, 25));
		endTimeField.setAlignmentX(0.1f);
		rightFishingSafariInfoPanel.add(endTimeField);
		endTimeField.setColumns(10);
		
		JPanel equipmentPanel = new JPanel();
		GridBagConstraints gbc_equipmentPanel = new GridBagConstraints();
		gbc_equipmentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_equipmentPanel.fill = GridBagConstraints.BOTH;
		gbc_equipmentPanel.gridx = 0;
		gbc_equipmentPanel.gridy = 3;
		mainPanel.add(equipmentPanel, gbc_equipmentPanel);
		GridBagLayout gbl_equipmentPanel = new GridBagLayout();
		gbl_equipmentPanel.columnWidths = new int[]{337, 215, 348, 0};
		gbl_equipmentPanel.rowHeights = new int[]{0, 0};
		gbl_equipmentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_equipmentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		equipmentPanel.setLayout(gbl_equipmentPanel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		equipmentPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		JList availableEquipmentList = new JList();
		scrollPane_1.setViewportView(availableEquipmentList);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		equipmentPanel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		Component verticalStrut_21 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_21);
		
		JButton addEquipmentEquipment = new JButton("L\u00E4gg till >>");
		addEquipmentEquipment.setName("addEquipmentButton");
		compArray(addEquipmentEquipment);
		addEquipmentEquipment.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(addEquipmentEquipment);
		
		Component verticalStrut_22 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_22);
		
		JButton removeEquipmentButton = new JButton("<< Ta bort");
		removeEquipmentButton.setName("removeEquipmentButton");
		compArray.add(removeEquipmentButton);
		removeEquipmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_1.add(removeEquipmentButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 0;
		equipmentPanel.add(scrollPane_2, gbc_scrollPane_2);
		
		JList rentedEquipmentList = new JList();
		scrollPane_2.setViewportView(rentedEquipmentList);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 4;
		mainPanel.add(buttonPanel, gbc_buttonPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(30);
		buttonPanel.add(horizontalStrut);
		
		JButton saveButton = new JButton("Spara");
		saveButton.setName("saveButton");
		compArray.add(saveButton);
		buttonPanel.add(saveButton);
		
		JButton cancelBookingButton = new JButton("Avboka");
		cancelBookingButton.setName("cancelBookingButton");
		compArray.add(cancelBookingButton);
		buttonPanel.add(cancelBookingButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(500);
		buttonPanel.add(horizontalStrut_1);
		
		JButton cancelButton = new JButton("Avbryt");
		cancelButton.setName("cancelButton");
		compArray.add(cancelButton);
		buttonPanel.add(cancelButton);
		
		JButton backButton = new JButton("Tillbaka");
		backButton.setName("backButton");
		compArray.add(backButton);
		buttonPanel.add(backButton);

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

}
