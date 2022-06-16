package _09_World_Clocks;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
    Timer timer;
    
    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    City city;
    JButton addCity;
    HashMap<JTextArea, City> citys = new HashMap<JTextArea, City>();
    ClockUtilities clockUtil;
    
   void worldClocks() {
    		city = new City();
    	
        //Setup UI + Clock util
        frame = new JFrame();
        panel = new JPanel();
        textArea = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(100, 100);
        frame.add(panel);
        
        addCity = new JButton("Add City");
        addCity.addActionListener(this);
        panel.add(addCity);
        
        
        
        clockUtil = new ClockUtilities();
        
        textArea.setText(city.setup("Chicago, US"));
        panel.add(textArea);
        
        // This Timer object is set to call the actionPerformed() method every
        // 1000 milliseconds
        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    		if(arg0.getSource() == timer) {
    			for (JTextArea i : citys.keySet()) {
    					i.setText(citys.get(i).getTimePerCity());
				}
        textArea.setText(city.getTimePerCity());
        frame.pack();
    		} else {
    			City city = new City();
    			JTextArea text = new JTextArea();
    			String cityName = JOptionPane.showInputDialog("What city would would you like to add?");
    			text.setText(city.setup(cityName));
    			citys.put(text, city);    	
    	        panel.add(text);
    		}
    }
}
