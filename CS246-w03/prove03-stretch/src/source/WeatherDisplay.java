package source;

<<<<<<< HEAD
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherDisplay {
    private final List<String> locations;
    public List<WeatherConditions> selectedInformation = new ArrayList<>();

    public WeatherDisplay(List<String> locations) {
        this.locations = locations;
    }

    /* Display limited current information for the locations you've entered in the previous method */
    public void  forecastingCurrent() {
        // Where I want to go
        //https://api.openweathermap.org/data/2.5/weather?q=Rexburg&apiKey=f4051f9ae5c7a4eb58c335ed524c93c6
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = ""; // query to the server

        int counter = 0;
        // loop through the locations
        for(String location : locations ) {
            System.out.format("%nCity #%d is: %s%n", ++counter, location);

            // Get the information from the server
            try {
                query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String responseBody = null;
            try {
                URLConnection connection = new URL(url + "?" + query).openConnection();
                connection.setRequestProperty("Accept-Charset", charset);
                InputStream response = connection.getInputStream();
                try (Scanner scanner = new Scanner(response)) {
                    responseBody = scanner.useDelimiter("\\A").next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Deserialize the Json file into the current weather class
            Gson gson = new Gson();
            WeatherConditions wc = gson.fromJson(responseBody, WeatherConditions.class);

            System.out.println(wc.toString());
        }
        System.out.println("END OF CURRENT DATA PER LOCATION FOR 40 DAYS.");
    }

    /* Display the forecast for the list of locations */
    public void forecasting40() {
        String urlForecast = "https://api.openweathermap.org/data/2.5/forecast";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = ""; // query to the server

        // loop through the locations
        for(String location: locations) {

            //  Get the information from the server
            try {
                query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String responseBodyForecast = null;
            try {
                URLConnection connection = new URL(urlForecast + "?" + query).openConnection();
                connection.setRequestProperty("Accept-Charset", charset);
                InputStream responseForecast = connection.getInputStream();
                try (Scanner scanner = new Scanner(responseForecast)) {
                    responseBodyForecast = scanner.useDelimiter("\\A").next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Deserialize the Json file into the forecast classes
            Gson gsonForecast = new Gson();
            WeatherForecast wf = gsonForecast.fromJson(responseBodyForecast, WeatherForecast.class);

            selectedInformation = wf.forecastingFiveDays();

            System.out.format("%nCITY: %s%n", wf.toString());
            wf.retrieveForecast();
            System.out.format("This was 40 days of forecast for %s. %n%n", wf.city.get("name"));
        }
        System.out.println("END OF FORECASTED DATA PER LOCATION FOR 40 DAYS.");
    }

    public void forecastingMaxTemperature(int i) {
        if(i > 40)
            System.out.println("Cannot retrieve more than 40 values.");
        else {
            selectedInformation.
        }
=======
import java.util.List;

public class WeatherDisplay {
    public WeatherDisplay(List<String> locations) {
>>>>>>> 2369fcecc948adc213b5762c4b6e622e940f40cf
    }
}
