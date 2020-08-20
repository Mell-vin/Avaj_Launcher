package avajlauncher.classes;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
	private boolean registered = false;
	private Flyable helicopter;
	private NewPlane np = new NewPlane();

    public void updateConditions() {

    }

    public void registerTower(WeatherTower towerWeather) {
    	this.helicopter = np.newAircraft("Helicopter", this.name, this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());
    	towerWeather = new WeatherTower();
    	setRegistered(true);
        setWeatherTower(towerWeather);
        this.weatherTower.register(helicopter);
        this.weatherTower.getWeather(this.getCoordinates());
    }

    public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	protected Helicopter(String Name, Coord coord, WeatherTower towerWeather) {
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