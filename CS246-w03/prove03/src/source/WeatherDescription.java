package source;

public class WeatherDescription {
    String description;

    public WeatherDescription (String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
