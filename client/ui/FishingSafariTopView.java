import javax.swing.JPanel;
import java.awt.GridLayout;

import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import java.util.Properties;


public class FishingSafariTopView extends JPanel {

	/**
	 * Create the panel.
	 */
	public FishingSafariTopView() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		UtilDateModel model = new UtilDateModel();
		Properties prop = new Properties();
		prop.put("text.today","Today");
		prop.put("text.month", "Month");
		prop.put("text.year", "Year");
		
		JPanel leftDatePickerPanel = new JPanel();
		add(leftDatePickerPanel);
		JDatePanelImpl startDatePanel = new JDatePanelImpl(model,prop);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(startDatePanel,new DateComponentFormatter());
		leftDatePickerPanel.add(startDatePicker);
		
		JPanel rightDatePickerPanel = new JPanel();
		add(rightDatePickerPanel);
		JDatePanelImpl endDatePanel = new JDatePanelImpl(model,prop);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel,new DateComponentFormatter());
		rightDatePickerPanel.add(endDatePicker);

	}

}
