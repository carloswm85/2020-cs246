<<<<<<< HEAD
package source;

import java.io.IOException;
import java.util.*;

/**
 * This class handles the Stretch Challenge portion of the assignment.
 */
public class MultipleCityExperimenter {

    /**
     * Gets forecasts for a list of cities and sorts and displays them
     * according to wind speed and temperature.
     */
    public void compareCityList() {
        List<String> cities = new ArrayList<>();
        cities.add("Rexburg");
        cities.add("London");
        cities.add("Los Angeles");
        cities.add("Boston");
        cities.add("Tampa");

        WeatherDataLoader loader = new WeatherDataLoader();

        // There are different ways to accomplish this, but I decided to create a new class
        // WeatherSummary to hold a city name, max temperature, and max wind speed to make
        // all of these tasks simple and concise.
        List<WeatherSummary> summaryList = new ArrayList<>();

        for (String city : cities) {
            try {
                WeatherForecast forecast = loader.getForecast(city);

                // This will populate the summary object for this forecast and add it to the list
                WeatherSummary summary = WeatherSummary.loadFromForecast(city, forecast);
                summaryList.add(summary);
            }
            catch (IOException ex) {
                System.err.println("Error getting forecast for " + city);
                ex.printStackTrace();
            }
        }

        // This method of sorting creates a new anonymous class to define the comparison that
        // needs to happen. (Shown below is another way)
        summaryList.sort(new Comparator<WeatherSummary>() {
            @Override
            public int compare(WeatherSummary o1, WeatherSummary o2) {
                // Notice that we are doing o2 first, this is because we want a descending sort
                return Float.compare(o2.getMaxTemp(), o1.getMaxTemp());
            }
        });

        System.out.println("\nCities, sorted by max temperature:");
        for (WeatherSummary summary : summaryList) {
            System.out.println(summary);
        }

        // This is a more modern approach using a lambda function
        summaryList.sort((o1, o2) -> Float.compare(o2.getMaxWind(), o1.getMaxWind())); // put o2 first for descending sort
        System.out.println("\nCities, sorted by max wind speed:");
        for (WeatherSummary summary : summaryList) {
            System.out.println(summary);
        }

    }

}
=======
package source;public class MultipleCityExperimenter {
}
>>>>>>> 2369fcecc948adc213b5762c4b6e622e940f40cf
