//import mypackage.Coord;

package avajlauncher.classes;

public class WeatherTower extends Tower {
	//static String 
	static WeatherProvider wp = new WeatherProvider();
	
    public String getWeather(Coord coord) {
        return wp.getCurrentWeather(coord);
    }

    protected void changeWeather() {
        
    }
}