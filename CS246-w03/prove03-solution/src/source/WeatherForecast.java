<<<<<<< HEAD
package source;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is essentially an EntityBean that holds the information for a complete forecast result.
 */
public class WeatherForecast {
    @SerializedName("list")
    private List<WeatherForecastItem> forecastItems;

    public List<WeatherForecastItem> getForecastItems() {
        return forecastItems;
    }

    public void setForecastItems(List<WeatherForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }
}
=======
package source;public class WeatherForecast {
}
>>>>>>> 2369fcecc948adc213b5762c4b6e622e940f40cf
