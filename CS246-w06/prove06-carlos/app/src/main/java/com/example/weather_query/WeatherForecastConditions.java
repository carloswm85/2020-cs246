package com.example.weather_query;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Class container, used by the CurrentTemperature class to get the full information
 * from the web Weather API Json file. The map is instantiated as a as a HashMap.
 * @author Carlos Mercado
 */

public class WeatherForecastConditions {
    public static final String TAG = "CWM_WF_CONDITION";

    public Integer id;
    public String main;
    public String description;
    public String icon;

    public WeatherForecastConditions(Integer id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

}
