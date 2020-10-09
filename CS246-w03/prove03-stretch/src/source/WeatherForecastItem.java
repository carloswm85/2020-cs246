package source;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class WeatherForecastItem {

    // Retrieve: Time, Temperature, Weather conditions, Wind
    @SerializedName("dt_txt") // Time
    String date;

    @SerializedName("main") // Temperature
    public Map<String, Float> measurements;

    @SerializedName("weather") // Weather conditions
    public List<WeatherDescription> list;

    public Map<String, Float> wind; // Wind


    public WeatherForecastItem(String date) {
        this.date = date;
        this.measurements = new HashMap<>();
        this.list = new ArrayList<>();
        this.wind = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Date = %s%n" +
                        "Temperature = %f%n" +
                        "Weather description = %s%n" +
                        "Wind speed = %f%n"
                , date
                , measurements.get("temp")
                , this.returnWeatherDescription()
                , wind.get("speed")

        );
    }

    private String returnWeatherDescription() {
        String content = "";
        for (WeatherDescription item : list)
            content = item.toString();
        return content;
    }
}
