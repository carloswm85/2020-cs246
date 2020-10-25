package com.example.weather_query;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    public static final String TAG = "CWM_WF_ITEM";

    // Retrieve: Time, Temperature, Weather conditions, Wind
    @SerializedName("dt_txt") // Time
    String date;

    @SerializedName("main") // Temperature
    public Map<String, Object> measurements;

    @SerializedName("weather") // Weather conditions
    public List<WeatherForecastConditions> list;

    public Map<String, Float> wind; // Wind


    public WeatherForecastItem(String date) {
        this.date = date;
        this.measurements = new HashMap<>();
        this.list = new ArrayList<>();
        this.wind = new HashMap<>();
    }

}
