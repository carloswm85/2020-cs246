package source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // --------------------------------------------------- PART A -------------------------------------------------
        System.out.println("\nPART I, II AND III: WORKING WITH CURRENT CONDITIONS");
        List<String> locations = new ArrayList<>();
        inputLocations(locations);
        // Get information of as many cities as you like.
        WeatherDisplay wd = new WeatherDisplay(locations);
        // Get current conditions
        wd.forecastingCurrent();

        /* DONE */
        // --------------------------------------------------- PART B -------------------------------------------------
        System.out.println("\nPART IV: WORKING WITH FORECAST");
        // Get the forecast for each location for the next 40 days
        wd.forecasting40();
        //
        wd.forecastingMaxTemperature(5);
        //
        wd.forecastingMaxWind(5);
    }

    /* Getting a list of cities */
    private static void inputLocations(List<String> locations) {
        Scanner scanner = new Scanner( System.in );

        System.out.println("How many locations do you want to know?");
        int locationsAmount = Integer.parseInt(scanner.nextLine());// Input how many cities you want
        System.out.format("%nEntered %d location names:%n", locationsAmount);

        for (int i = 0; i < locationsAmount; i++)
            locations.add(scanner.nextLine());    // Input the names

        System.out.printf("%nEntered locations are:\n"); // Print the list of names you've entered
        for(String location : locations ) {
            if(!location.isBlank())
                System.out.format(" %s%n", location);
        }
    }
}
