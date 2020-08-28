package avajlauncher.classes.aircrafts;

import avajlauncher.classes.Coord;
import avajlauncher.classes.Flyable;
import avajlauncher.classes.NewPlane;
import avajlauncher.classes.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
	private boolean registered = false;
	private Flyable helicopter;
	private NewPlane np = new NewPlane();

	public void updateConditions() {
    	if (this.isRegistered() == true && this.coordinates.getHeight() > 0) {
    		if(this.weatherTower.getWeather(getCoordinates()) == "RAIN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : Roter blades drippin, drip drip.");
        		this.updatePlaneInfo(0, 5, 0);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SNOW") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : I was with Jet doing white powder in his youth..");
        		this.updatePlaneInfo(0, 0, -12);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SUN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : Icarus flew too close. Let me leave some space..");
        		this.updatePlaneInfo(0, 10, 2);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "FOG") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : My blades clear all misty ness!!");
        		this.updatePlaneInfo(0, 0, -3);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "no weather") {
        		this.weatherTower.unregister(this.helicopter);
        	}
    	} else if (this.isRegistered() == true && this.coordinates.getHeight() <= 0) {
    		this.updatePlaneInfo(this.coordinates.getLatitude(), this.coordinates.getLongitude(), 0);
    	}
    }
    
	public void updatePlaneInfo(int lat, int lon, int height) {
		this.coordinates.setLatitude(lat);
		this.coordinates.setLongitude(lon);
		if (this.coordinates.getHeight() >= 100) {
			this.coordinates.setHeight(100);
		} else if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this.helicopter);
			this.setRegistered(false);
		} else {
			this.coordinates.setHeight(height);
		} 
}

    public void registerTower(WeatherTower towerWeather) {
    	this.helicopter = np.newAircraft("Helicopter", this.name, this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight(), id);
    	towerWeather = new WeatherTower();
    	setRegistered(true);
        setWeatherTower(towerWeather);
        this.weatherTower.register(helicopter);
    }

    public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	protected Helicopter(String type, String Name, Coord coord, WeatherTower towerWeather, long id) {
        super(Name, type, coord, id);
        setWeatherTower(towerWeather);
    }

    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }

    public void setWeatherTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

//	public void PrintInfo() {
//		System.out.println("Helicopter [weatherTower=" + weatherTower + ", id=" + id + ", name=" + name + ", coordinates="
//				+ coordinates + ", getWeatherTower()=" + getWeatherTower() + ", getId()=" + getId() + ", getName()="
//				+ getName() + ", getCoordinates()=" + getCoordinates() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]");
//	}
}