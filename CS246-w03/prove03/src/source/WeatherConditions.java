package source;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class WeatherConditions {
    public int id;
    public String name;

    @SerializedName("main")
    public Map<String, Float> measurements;

    public WeatherConditions(int id, String name) {
        this.id = id;
        this.name = name;

        this.measurements = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format(
                "id = %d,%n" + "name = %s%n" + "temp = %f"
                , id, name, measurements.get("temp")
        );
    }
}
