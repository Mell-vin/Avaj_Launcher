package avajlauncher.classes;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    //TODO weather creation algorithm, using random number generators or sum.

    public WeatherProvider() {
    	
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coord coord) {
        float lat = coord.getLatitude();
        float lon = coord.getLongitude();
        float high = coord.getHeight();
        float sum = lat + lon + high;

        while (sum > 20) {
           	sum = sum / 4;
        }
        if (sum < 0) {
        	sum *= -1;
        }
        if (high == 0) {
        	return "no weather";
        }
        if (sum >= 0 && sum <= 4) {
        	System.out.println("sum is: " + sum);
        	return WeatherProvider.weather[0];
        } else if (sum > 4 && sum <= 10) {
        	System.out.println("sum is: " + sum);
        	return WeatherProvider.weather[3];
        } else if (sum > 10 && sum <= 15) {
        	System.out.println("sum is: " + sum);
        	return WeatherProvider.weather[2];
        } else if (sum > 15) {
        	System.out.println("sum is: " + sum);
        	return WeatherProvider.weather[1];
        } else {
        	System.out.println("nulling.. and sum is: " + sum);
        	return null;
        }
    }
}