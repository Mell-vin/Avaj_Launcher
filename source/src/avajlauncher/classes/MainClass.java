package avajlauncher.classes;

import java.util.ArrayList;
import java.util.List;
import avajlauncher.classes.*;

class MainClass { 
	private static WeatherTower weatherTower;
	private static WeatherProvider wp = new WeatherProvider();
	private static ArrayList<Flyable> activePlanes = new ArrayList<Flyable>();
	static ArrayList<String[]> PlaneList = new ArrayList<String[]> ();
	static CheckFileFormat cff = new CheckFileFormat();
	static NewPlane np = new NewPlane();
	static int sims = 0;
	static long id = 0;
	
	public static void main(String[] args) {
		if (args.length > 0) {
			if(cff.FileReader(args[0]) == 1) {
				sims = cff.getIterations();
				PlaneList = cff.getPlaneList();
				for (int temp = 0; temp < PlaneList.size(); temp++) {
					if (Integer.parseInt(PlaneList.get(temp)[4]) > 0
					&& Integer.parseInt(PlaneList.get(temp)[3]) >= 0
					&& Integer.parseInt(PlaneList.get(temp)[2]) >= 0)
					{
						Flyable singlePlane = np.newAircraft(PlaneList.get(temp)[0],
						PlaneList.get(temp)[1], Integer.parseInt(PlaneList.get(temp)[2]),
						Integer.parseInt(PlaneList.get(temp)[3]),
						Integer.parseInt(PlaneList.get(temp)[4]),
						id++
						);
						activePlanes.add(singlePlane);
					} else {
						System.out.println("Invalid height,latitude/longitude for "
						+ PlaneList.get(temp)[0] + "("
						+ PlaneList.get(temp)[1] + "). Sorry, not taking off (''-  )");
					}
				}
				for (Flyable activePlane : activePlanes) {
					activePlane.registerTower(weatherTower);
				}
				for (int i = 0; i < sims; i++) {
					for (Flyable activePlane : activePlanes) {
						activePlane.updateConditions();
					}
				}
			}
		} else {
			System.out.println("No scenario file given");
		}
	}
}
