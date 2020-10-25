package com.example.weather_query;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class container, used by the CurrentTemperature class to get the full information
 * from the web Weather API Json file. The map is instantiated as a as a HashMap.
 * @author Carlos Mercado
 */

public class WeatherForecastContainer {
    public static final String TAG = "CWM_WF_CONTAINER"; // Logcat TAG

    @SerializedName("list")
    public List<WeatherForecastItem> forecastList;

    public WeatherForecastContainer() {
        forecastList = new ArrayList<>();
        System.out.println(forecastList);
    }
}
