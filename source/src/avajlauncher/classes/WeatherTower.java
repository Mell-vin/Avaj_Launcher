//import mypackage.Coord;

package avajlauncher.classes;

public class WeatherTower extends Tower {
	static String weather;
	static WeatherProvider wp = new WeatherProvider();
	
    public String getWeather(Coord coord) {
    	WeatherTower.weather = wp.getCurrentWeather(coord);
        return WeatherTower.weather;
    }

    protected void changeWeather() {
        if (WeatherTower.weather == "RAIN") {
        	
        }
    }
}