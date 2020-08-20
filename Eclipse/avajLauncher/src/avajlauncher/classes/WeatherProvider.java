package avajlauncher.classes;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    //TODO weather creation algorithm, using random number generators or sum.

    public WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coord coord) {
        return weather[0]; //TODO for now
    }
    
}