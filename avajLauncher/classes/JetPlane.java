package avajlauncher.classes;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private boolean registered = false;
    private Flyable jetPlane;
	private NewPlane np = new NewPlane();

	public void updateConditions() {
    	if (this.isRegistered() == true) {
    		if(this.weatherTower.getWeather(getCoordinates()) == "RAIN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : My engines cant suck up all this water.");
        		this.updatePlaneInfo(5, 0, 0);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SNOW") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : Aah, This white powder reminds me of my youth..");
        		this.updatePlaneInfo(0, 0, -7);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SUN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : I don't need auto pilot when the sun is this bright.");
        		this.updatePlaneInfo(10, 0, 2);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "FOG") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&%#) : Is this fog or a cloud??");
        		this.updatePlaneInfo(1, 0, 0);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "no weather") {
        		this.weatherTower.unregister(this.jetPlane);
        	}
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