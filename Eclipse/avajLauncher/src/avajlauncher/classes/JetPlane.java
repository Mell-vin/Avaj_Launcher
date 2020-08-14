package avajlauncher.classes;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public void updateConditions() {
    	
    }

    public void registerTower(WeatherTower weatherTower) {
        
    }

    protected JetPlane(String Name, Coord coord, WeatherTower towerWeather) {
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
		System.out.println("Helicopter id=" + id + ", name=" + name + ", coordinates="
				+ coordinates + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getCoordinates()=" + getCoordinates() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]");
	}
}