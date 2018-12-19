package datepicker;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 * This program demonstrates how to use JDatePicker to display a calendar 
 * component in a Swing program.
 * @author www.codejava.net
 *
 */
public class JDatePickerDemo extends JFrame implements ActionListener {
	
	final private JDatePickerImpl datePicker;
	
         public JDatePickerDemo() {
		super("Calendar Component Demo");
		setLayout(new FlowLayout());
		super.setResizable(true);
		add(new JLabel("Select the Date: "));
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(2012, 04, 05);
		model.setSelected(true);
		Properties i18nStrings = new Properties();
//		UtilCalendarModel model = new UtilCalendarModel();
//		SqlDateModel model = new SqlDateModel();
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model,i18nStrings);
		
//		datePicker = new JDatePickerImpl(datePanel);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
                
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		
		add(buttonOK);
		
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JDatePickerDemo().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// for UtilDateModel, the value returned is of type java.util.Date
		Date selectedDate = (Date) datePicker.getModel().getValue();
                String dt = selectedDate.toString();
		//chequesprint.Chequesprint.jFormattedTextField2.setText(dt);
		// for UtilCalendarModel, the value returned is of type java.util.Calendar
//		Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
//		Date selectedDate = selectedValue.getTime();

		// for SqlDateModel, the value returned is of type java.sql.Date
//		java.sql.Date selectedDate = (java.sql.Date) datePicker.getModel().getValue();
		
		JOptionPane.showMessageDialog(this, "The selected date is " + dt);
	}

}