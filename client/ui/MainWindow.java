package client.ui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;

public class MainWindow extends JPanel {

	ArrayList<JComponent> compArray = new ArrayList<JComponent>();
	HashMap<String,JComponent> compMap = new HashMap<String,JComponent>();

	public MainWindow() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{38, 422, 91, 115, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topPanel.fill = GridBagConstraints.BOTH;
		gbc_topPanel.gridx = 0;
		gbc_topPanel.gridy = 0;
		add(topPanel, gbc_topPanel);
		
		JLabel lblSmlndskaFiskefrbundet = new JLabel("Sm\u00E5l\u00E4ndska Fiskef\u00F6rbundet");
		lblSmlndskaFiskefrbundet.setFont(new Font("Tahoma", Font.PLAIN, 25));
		topPanel.add(lblSmlndskaFiskefrbundet);
		
		JPanel middlePanel = new JPanel();
		GridBagConstraints gbc_middlePanel = new GridBagConstraints();
		gbc_middlePanel.insets = new Insets(0, 0, 5, 0);
		gbc_middlePanel.fill = GridBagConstraints.BOTH;
		gbc_middlePanel.gridx = 0;
		gbc_middlePanel.gridy = 1;
		add(middlePanel, gbc_middlePanel);
		
		JPanel topButtonPanel = new JPanel();
		GridBagConstraints gbc_topButtonPanel = new GridBagConstraints();
		gbc_topButtonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_topButtonPanel.gridx = 0;
		gbc_topButtonPanel.gridy = 2;
		add(topButtonPanel, gbc_topButtonPanel);
		topButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton newBookingButton = new JButton("Ny kundbokning");
		newBookingButton.setName("newBookingButton");
		compArray.add(newBookingButton);
		newBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		topButtonPanel.add(newBookingButton);
		
		JButton handleBookingButton = new JButton("Hantera bokning");
		handleBookingButton.setName("handleBookingButton");
		compArray.add(handleBookingButton);
		handleBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		topButtonPanel.add(handleBookingButton);
		
		JPanel bottomPanelButton = new JPanel();
		GridBagConstraints gbc_bottomPanelButton = new GridBagConstraints();
		gbc_bottomPanelButton.fill = GridBagConstraints.BOTH;
		gbc_bottomPanelButton.gridx = 0;
		gbc_bottomPanelButton.gridy = 3;
		add(bottomPanelButton, gbc_bottomPanelButton);
		bottomPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton handleFishingSafariButton = new JButton("Hantera fiskesafari");
		handleFishingSafariButton.setName("handleFishingSafariButton");
		compArray.add(handleFishingSafariButton);
		handleFishingSafariButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottomPanelButton.add(handleFishingSafariButton);
		
		JButton handleDestinationButton = new JButton("Hantera safarim\u00E5l");
		handleDestinationButton.setName("handleDestinationButton");
		handleDestinationButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottomPanelButton.add(handleDestinationButton);
		
		JButton btnHanteraBoende = new JButton("Hantera boende");
		btnHanteraBoende.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottomPanelButton.add(btnHanteraBoende);
		
		JButton btnHanteraKund = new JButton("Hantera kunder");
		btnHanteraKund.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bottomPanelButton.add(btnHanteraKund);

	}

	private void initCompMap(){
		for(JComponent comp : compArray){
			compMap.put(comp.getName(),comp);
		}
	}
	public HashMap<String,JComponent> getCompMap(){
		return compMap;
	}
	private JLabel putImage(String filepath){
		JLabel picLabel = null;
		try{
			BufferedImage picture = ImageIO.read(new File(filepath));
			picLabel = new JLabel(new ImageIcon(picture));
		}
		catch(IOException e){
			//...
		}
		return picLabel;
	}

}
