package com.example.weather_query;

//import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Runnable class.
 * Retrieves <code>temperature</code> from this class to any activity.
 * @author Carlos Mercado
 */

class CurrentTemperature implements Runnable {
    private final String location;  // Get temperature from this location
    private final MainActivity activity;    // This runnable class is run from the MainActivity
    public static final String TAG = "CWM_CURRENT_TEMPERATURE"; // Logcat TAG

    // Constructor used during development, no longer used in final version.
//    public CurrentTemperature(String location) {
//        this.location = location;
//        activity = null;
//    }

    /**
     * Class constructor.
     * @param activity
     * @param location
     */
    public CurrentTemperature(MainActivity activity, String location) {
        this.location = location;
        this.activity = activity;
    }

    /**
     * Runnable method.
     */
    @Override
    public void run() {
        retrieveTemperature();
    }

    /**
     * Retrieves the full information from the weather API, it uses <code>location</code> as
     * leading parameter to know what to retrieve. Then displays the information (<code>temperature</code>)
     * to the UI thread through a toast. The <code>activity</code> class variables is used to do
     * the latter.
     * @see WeatherConditions
     */
    public void retrieveTemperature() {
        // Retrieving information from (example): https://api.openweathermap.org/data/2.5/weather?q=Zapala&apiKey=f4051f9ae5c7a4eb58c335ed524c93c6&units=metric
        String url = "https://api.openweathermap.org/data/2.5/weather";
        String charset = "UTF-8";
        String apiKey = "f4051f9ae5c7a4eb58c335ed524c93c6";
        String units = "metric";
        String query = "";

        // query variable is the composition of all other values: location, apikey, units.
        // query is the API Weather URL from where the information is retrieved.
        try {
            query = String.format("q=%s&apiKey=%s&units=%s", URLEncoder.encode(location, charset), URLEncoder.encode(apiKey, charset), URLEncoder.encode(units, charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // The information from the weather API is retrieved to <code>responseBody</cody>
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

        // Time to deserializa the information from weather API.
        Gson gson = new Gson();
        // WeatheConditions class is used as a template class for the deserialization.
        WeatherConditions wc = gson.fromJson(responseBody, WeatherConditions.class);


        // Logcat information used during development.
//        String message1 = "Main ID? " + Looper.getMainLooper().getThread().getId() + ", and Main name? " + Looper.getMainLooper().getThread().getName();
//        Log.d(TAG, message1);
//        String message2 = "Current Thread ID? " + Thread.currentThread().getId() + ", and Current Thread name? " + Thread.currentThread().getName();
//        Log.d(TAG, message2);
        String message3 = "Getting temperature for location (" + location + "): " + wc.measurements.get("temp");
        Log.d(TAG, message3);

        // temperature information is sent to the main activity for displaying.
        activity.runOnUiThread(() -> {
            // This is the code that will run on the UI thread.
            Toast toast = Toast.makeText(activity, message3, Toast. LENGTH_SHORT);
            toast.show();
        });


    }
}
