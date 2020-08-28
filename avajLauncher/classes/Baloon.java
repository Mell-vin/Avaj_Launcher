package avajlauncher.classes;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
	private boolean registered = false;
	private Flyable baloon;
	private NewPlane np = new NewPlane();

    public void updateConditions() {
    	if (this.isRegistered() == true) {
    		if(this.weatherTower.getWeather(getCoordinates()) == "RAIN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : Ooh my flame is being extinguished!!");
        		this.updatePlaneInfo(0, 0, -5);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SNOW") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : Rubber shrinks in the snow :(");
        		this.updatePlaneInfo(0, 0, -15);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "SUN") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : I've got sunshiiiiiine, on a clouuuudyy daay.");
        		this.updatePlaneInfo(0, 2, 4);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "FOG") {
        		System.out.println(this.getType()
        				+ this.getName()
        				+ " (#*" + this.getId()
        				+ "&$%) : I can't see my hand infront of my face.");
        		this.updatePlaneInfo(0, 0, -3);
        	} else if (this.weatherTower.getWeather(getCoordinates()) == "no weather") {
        		this.weatherTower.unregister(this.baloon);
        	}
    	}
    }
    
    public void updatePlaneInfo(int lat, int lon, int height) {
        		this.coordinates.setLatitude(lat);
        		this.coordinates.setLongitude(lon);
        		if (this.coordinates.getHeight() >= 100) {
        			this.coordinates.setHeight(100);
        		} else if (this.coordinates.getHeight() <= 0) {
        			this.weatherTower.unregister(this.baloon);
        			this.setRegistered(false);
        		} else {
        			this.coordinates.setHeight(height);
        		} 
    }

    public void registerTower(WeatherTower towerWeather) {
    	this.baloon = np.newAircraft("Baloon", this.name,
    			this.coordinates.getLongitude(),
    			this.coordinates.getLatitude(),
    			this.coordinates.getHeight(),
    			id
    	);
    	towerWeather = new WeatherTower();
    	setRegistered(true);
        setWeatherTower(towerWeather);
        this.weatherTower.register(baloon);
    }

    public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	protected Baloon(String type,
			String Name,
			Coord coord,
			WeatherTower
			towerWeather,
			long id
			) {
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