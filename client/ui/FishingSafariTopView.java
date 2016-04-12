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
		
		JPanel panel = new JPanel();
		add(panel);
		JDatePanelImpl startDatePanel = new JDatePanelImpl(model,prop);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(startDatePanel,new DateComponentFormatter());
		panel.add(startDatePicker);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		JDatePanelImpl endDatePanel = new JDatePanelImpl(model,prop);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel,new DateComponentFormatter());
		panel_1.add(endDatePicker);

	}

}
