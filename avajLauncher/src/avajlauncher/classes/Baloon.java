package avajlauncher.classes;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        
    }

    protected Baloon(String Name, Coord coord, WeatherTower towerWeather) {
        super(Name, coord);
        weatherTower = towerWeather;
    }

    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }

    public void setWeatherTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}