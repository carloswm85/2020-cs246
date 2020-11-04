package com.example.weather_query;

import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

public class CurrentForecast implements Runnable {

    private final String location;  // Get forecast from this location
    private final ListView list;
    public static final String TAG = "CWM_CURRENT_FORECAST"; // Logcat TAG

    /**
     * Class constructor.
     * @param location
     * @param list
     */
    public CurrentForecast(ListView list, String location) {
        this.location = location;
        this.list = list;
    }

    /**
     * Runnable method. It runs just one method from the current class.
     */
    @Override
    public void run() {
        forecastToListView();
    }

    private void forecastToListView() {
        String response = WeatherDataRetriever.forecast(location);
//        Gson gson = new Gson();
//        WeatherForecastContainer wf = gson.fromJson(response, WeatherForecastContainer.class);
//
//        System.out.println(wf);
        Log.d(TAG, response);
    }
}
