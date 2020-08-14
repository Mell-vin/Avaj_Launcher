package avajlauncher.classes;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        
    }

    protected Baloon(String Name, Coord coord, WeatherTower towerWeather) {
        super(Name, coord);
        setWeatherTower(towerWeather);
    }

    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }

    public void setWeatherTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    public void PrintInfo() {
		System.out.println("Helicopter [weatherTower=" + weatherTower + ", id=" + id + ", name=" + name + ", coordinates="
				+ coordinates + ", getWeatherTower()=" + getWeatherTower() + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getCoordinates()=" + getCoordinates() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]");
	}
}