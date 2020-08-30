package avajlauncher.classes.aircrafts;

import avajlauncher.classes.Coord;
import avajlauncher.classes.Flyable;
import avajlauncher.classes.WeatherTower;

public abstract class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height, long id) {
		if(type.equals("Baloon")) {
			Coord BaloonCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newBaloon = new Baloon(type, name, BaloonCoord, weathertower, id);
			return newBaloon;
		} else if(type.equals("Helicopter")) {
			Coord HeliCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newHeli = new Helicopter(type, name, HeliCoord, weathertower, id);
			return newHeli;
		} else if (type.equals("JetPlane")) {
			Coord JetCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newJet = new JetPlane(type, name, JetCoord, weathertower, id);
			return newJet;
		}
		return null; //TODO create unique ID for each plane.
	}
}
