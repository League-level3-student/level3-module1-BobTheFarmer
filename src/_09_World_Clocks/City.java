package _09_World_Clocks;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.Timer;

public class City {
	ClockUtilities clockUtil;
    TimeZone timeZone;
    
    String city;
    String dateStr;
    String timeStr;
    
	void setup() {
		clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        city = "Chicago, US";
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        System.out.println(dateStr);
        textArea.setText(city + "\n" + dateStr);
	}
	
	TextBox 
}
