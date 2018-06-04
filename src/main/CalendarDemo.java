package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Presentacion.vistas.vistaCalendario.DateLabelFormatter;

public class CalendarDemo extends JPanel{


	    public static void main(String[] args) {
	        JFrame frame = new JFrame("JXPicker Example");
	        JPanel panel = new JPanel();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(400, 400, 250, 100);

	        UtilDateModel model = new UtilDateModel();
	    	//model.setDate(20,04,2014);
	    	// Need this...
	    	Properties p = new Properties();
	    	p.put("text.today", "Today");
	    	p.put("text.month", "Month");
	    	p.put("text.year", "Year");
	    	JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    	// Don't know about the formatter, but there it is...
	    	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    	
	    	String fecha = datePicker.getJFormattedTextField().getText();
	    	DateLabelFormatter dlf = new DateLabelFormatter();
	    	dlf.ge
	    	Calendar cal = DateLabelF
	    	panel.add(datePicker);
	        frame.getContentPane().add(panel);

	        frame.setVisible(true);
	    }
}
