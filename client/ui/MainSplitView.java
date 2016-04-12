//package client.ui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.*;

public class MainSplitView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainSplitView(Component comp1, Component comp2) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,comp1,comp2);
		add(splitPane);

	}

}
