package avajlauncher.classes;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;


    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coord coord) {
        return weather[0]; //for now
    }
    
}