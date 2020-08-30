package avajlauncher.classes.aircrafts;

import avajlauncher.classes.Coord;
import avajlauncher.classes.Flyable;
import avajlauncher.classes.NewPlane;
import avajlauncher.classes.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private boolean registered = false;
    private Flyable jetPlane;
	private NewPlane np = new NewPlane();

	public void updateConditions() {
		String string = this.getType()
				+ this.getName()
				+ " (#*" + this.getId()
				+ "&$%) : ";
		
    	if (this.isRegistered() == true  && this.coordinates.getHeight() > 0) {
    		if(this.weatherTower.getWeather(getCoordinates()) == "RAIN") {
    			string = string + "My engines cant suck up all this water.";
    			this.writeToFile(string);
        		System.out.println(string);
        		this.updatePlaneInfo(5, 0, 0);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SNOW") {
        		string = string + "Aah, This white powder reminds me of my youth..";
        		this.writeToFile(string);
        		System.out.println(string);
        		this.updatePlaneInfo(0, 0, -7);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SUN") {
        		string = string + "I don't need auto pilot when the sun is this bright.";
        		this.writeToFile(string);
        		System.out.println(string);
        		this.updatePlaneInfo(10, 0, 2);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "FOG") {
        		string = string + "Is this fog or a cloud??";
        		this.writeToFile(string);
        		System.out.println(string);
        		this.updatePlaneInfo(1, 0, 0);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "no weather") {
        		this.weatherTower.unregister(this.jetPlane);
        	}
    	}  else if (this.isRegistered() == true && this.coordinates.getHeight() <= 0) {
    		this.updatePlaneInfo(this.coordinates.getLatitude(), this.coordinates.getLongitude(), 0);
    	}
    }
    
	public void updatePlaneInfo(int lat, int lon, int height) {
		this.coordinates.setLatitude(lat);
		this.coordinates.setLongitude(lon);
		if (this.coordinates.getHeight() >= 100) {
			this.coordinates.setHeight(100);
		} else if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this.jetPlane);
			this.setRegistered(false);
		} else {
			this.coordinates.setHeight(height);
		} 
}

    public void registerTower(WeatherTower towerWeather) {
    	this.jetPlane = np.newAircraft("JetPlane", this.name, this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight(), id);
    	towerWeather = new WeatherTower();
    	setRegistered(true);
        setWeatherTower(towerWeather);
        this.weatherTower.register(jetPlane);
    }

    public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	protected JetPlane(String type, String Name, Coord coord, WeatherTower towerWeather, long id) {
        super(Name, type, coord, id);
        setWeatherTower(towerWeather);
    }


    public WeatherTower getWeatherTower() {
        return this.weatherTower;
    }

    public void setWeatherTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}