package _08_California_Weather;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * String cityName = Utilities.capitalizeWords( "National City" );
        WeatherData datum = weatherData.get(cityName);
        
        if( datum == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
        }
        
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	HashMap<String, WeatherData> weatherData;
	 
    JFrame frame;
    JPanel panel;
    JButton searchByCity;
    JButton searchByWeather;
    JButton searchByTemp;
    JTextField searchBar;
    JLabel searchResults;
    
    void start() {
        weatherData = Utilities.getWeatherData();
        
        //UI
        		frame = new JFrame("California Weather");
        		panel = new JPanel();
        		frame.add(panel);
        		frame.setVisible(true);
        		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        		panel.setPreferredSize(new Dimension(180*3+40+300, 90));
        		
        		searchByCity = new JButton("Search By City");
        		searchByWeather = new JButton("Search By Weather");
        		searchByTemp = new JButton("Search By Temperature");
        		
        		Dimension buttonDimension = new Dimension(180, 30);
        		searchByCity.setPreferredSize(buttonDimension);
        		searchByWeather.setPreferredSize(buttonDimension);
        		searchByTemp.setPreferredSize(buttonDimension);
        		
        		searchByCity.addActionListener(this);
        		searchByWeather.addActionListener(this);
        		searchByTemp.addActionListener(this);
        		
        		panel.add(searchByCity);
        		panel.add(searchByWeather);
        		panel.add(searchByTemp);
        		
        		searchBar = new JTextField();
        		searchBar.setPreferredSize(new Dimension(180*3+10, 30));
        		panel.add(searchBar);
        		
        		searchResults = new JLabel();
        		searchResults.setPreferredSize(new Dimension(180*3+10, 300));
        		panel.add(searchResults);
        		
        		frame.pack();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton sourse = (JButton) e.getSource();
		String searchTerm = searchBar.getText();
		String searchReasultString = "";
		
		//Search by city
		if(sourse == searchByCity) {
			for(String city: weatherData.keySet()) {
				if(city.contains(searchTerm)) {
					searchReasultString+="-" + city + ": " + weatherData.get(city) + "\n";
				}
 			}
		}
		
		//Search by weather
		//WORKING ON THIS, fix result display, add all search functions
		//Display Result
			searchResults.removeAll();
			searchResults.setText(searchReasultString);
			
	}
}
