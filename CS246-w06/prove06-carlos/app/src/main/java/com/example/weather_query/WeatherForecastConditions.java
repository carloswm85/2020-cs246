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

    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
