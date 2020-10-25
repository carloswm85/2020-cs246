package com.example.weather_query;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class WeatherDataRetriever {
    public static final String TAG = "CWM_WEATHER_DATA_RETRIEVER"; // Logcat TAG

    public WeatherDataRetriever() {
        // Nothing
    }

    public static String forecast(String location) {
        // Retrieving information from (example): https://api.openweathermap.org/data/2.5/forecast?q=Zapala&apiKey=f4051f9ae5c7a4eb58c335ed524c93c6&units=metric
        String url = "https://api.openweathermap.org/data/2.5/forecast";
        String charset = "UTF-8";
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = ""; // query to the server

        // query variable is the composition of all other values: location, apikey, units.
        // query is the API Weather URL from where the information is retrieved.
        try {
            query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String data = null;
        try {
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();
            try (Scanner scanner = new Scanner(response)) {
                data = scanner.useDelimiter("\\A").next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
