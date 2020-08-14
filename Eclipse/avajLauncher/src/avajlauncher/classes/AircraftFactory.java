package avajlauncher.classes;

public abstract class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		if(type.equals("Baloon")) {
			Coord BaloonCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newBaloon = new Baloon(name, BaloonCoord, weathertower);
			return newBaloon;
		} else if(type.equals("Helicopter")) {
			Coord HeliCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newHeli = new Helicopter(name, HeliCoord, weathertower);
			return newHeli;
		} else if (type.equals("JetPlane")) {
			Coord JetCoord = new Coord(longitude, latitude, height);
			WeatherTower weathertower = new WeatherTower();
			Flyable newJet = new JetPlane(name, JetCoord, weathertower);
			return newJet;
		}
		return null; //TODO create unique ID for each plane.
	}
}