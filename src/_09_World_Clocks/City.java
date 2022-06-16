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
    
	String setup(String cityName) {
		clockUtil = new ClockUtilities();

        // The format for the city must be: city, country (all caps)
        city = cityName;
        timeZone = clockUtil.getTimeZoneFromCityName(city);
        
        Calendar calendar = Calendar.getInstance(timeZone);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);
        
        System.out.println(dateStr);
       return city + "\n" + dateStr;
	}
	
	String getTimePerCity() {
		Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
        System.out.println(timeStr);
     return city + "\n" + dateStr + "\n" + timeStr;  
	}
}
