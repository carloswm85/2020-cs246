package com.example.weather_query;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Class container, used by the CurrentTemperature class to get the full information
 * from the web Weather API Json file. The map is instantiated as a as a HashMap.
 * @author Carlos Mercado
 */

public class WeatherConditions {
    @SerializedName("main")
    public Map<String, Object> measurements;

    public WeatherConditions() {
        measurements = new HashMap<>();
    }
}
