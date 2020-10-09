package source;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // --------------------------------------------------- PART A -------------------------------------------------
        System.out.println("\nPART I, II AND III: WORKING WITH CURRENT CONDITIONS");
        String responseBody = retrieveInformationPartA();

        Gson gson = new Gson();
        WeatherConditions wc = gson.fromJson(responseBody, WeatherConditions.class);

        System.out.println(wc.toString());
        /* DONE */
        // --------------------------------------------------- PART B -------------------------------------------------
        System.out.println("\nPART IV: WORKING WITH FORECAST");
        String responseBodyForecast = retrieveInformationPartB();

        Gson gsonForecast = new Gson();
        WeatherForecast wf = gsonForecast.fromJson(responseBodyForecast, WeatherForecast.class);

        System.out.println(wf.toString());
        wf.retrieveForecast();
        System.out.format("This was 40 days of forecast for %s. %n%n", wf.city.get("name"));
    }

    private static String retrieveInformationPartA() {
        // Were I want to go
        //https://api.openweathermap.org/data/2.5/weather?q=Rexburg&apiKey=f4051f9ae5c7a4eb58c335ed524c93c6
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = ""; // query to the server


        System.out.print("What's the city? ");
        Scanner scanner01 = new Scanner( System.in );
        String input = scanner01.nextLine();    // Location
        System.out.printf("Your input was %s%n", input);

        try {
            query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(input, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
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

        return responseBody;
    }

    private static String retrieveInformationPartB() {
        String urlForecast = "https://api.openweathermap.org/data/2.5/forecast";
        String charset = StandardCharsets.UTF_8.name();
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = ""; // query to the server


        System.out.print("What's the city? ");
        Scanner scanner01 = new Scanner( System.in );
        String input = scanner01.nextLine();    // Location
        System.out.printf("Your input was %s%n", input);

        try {
            query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(input, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
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
        return responseBodyForecast;
    }

}
