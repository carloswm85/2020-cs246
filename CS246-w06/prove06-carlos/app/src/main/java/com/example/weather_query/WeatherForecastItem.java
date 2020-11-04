package com.example.weather_query;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    public static final String TAG = "CWM_WF_ITEM";

    @SerializedName("dt_txt") // Time
    private String dateText;

    @SerializedName("main") // Temperature
    private Map<String, Float> measurements;

    @SerializedName("weather") // Weather conditions
    private List<WeatherForecastConditions> descriptions;

    private Map<String, Float> wind; // Wind

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public List<WeatherForecastConditions> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<WeatherForecastConditions> descriptions) {
        this.descriptions = descriptions;
    }

    public Map<String, Float> getWind() {
        return wind;
    }

    public void setWind(Map<String, Float> wind) {
        this.wind = wind;
    }
}
