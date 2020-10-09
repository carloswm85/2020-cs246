package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    public Map<String, Object> city;
    public List<WeatherForecastItem> list;
    public List<WeatherConditions> weather;
    int daysCount = 0;

    public WeatherForecast() {
        this.city = new HashMap<>();
        this.list = new ArrayList<>();
        this.weather = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Name = %s%n"
                , city.get("name")
        );
    }

    public void retrieveForecast() {
        for (WeatherForecastItem item : list)
            System.out.println("Forecast for day "+ ++daysCount + ":\n" + item.toString());
    }

    public List<WeatherConditions> forecastingFiveDays() {
        int limit;
        for (WeatherForecastItem item : list) {
            WeatherConditions newItem = new WeatherConditions();
            newItem.name = item.toString();
            newItem.measurements = item.measurements;
            newItem.wind = item.wind;

            weather.add(newItem);
        }
        return weather;
    }
}
