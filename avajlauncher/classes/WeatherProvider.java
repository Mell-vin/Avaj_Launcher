package avajlauncher.classes;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    //TODO

    public WeatherProvider() {
    	
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coord coord) {
    	    float lat = coord.getLatitude();
    	    float lon = coord.getLongitude();
    	    float high = coord.getHeight();
    	    float sum = lat + lon - high;

    	    if (sum < 0) {
    	    	sum *= -1;
    	    }
    	    if (high == 0) {
    	    	return "no weather";
    	    }
    	    return WeatherProvider.weather[(int) (sum % 4)];
    }
}