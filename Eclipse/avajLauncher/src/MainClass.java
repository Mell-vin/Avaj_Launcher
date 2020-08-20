import java.util.ArrayList;
import java.util.List;
import avajlauncher.classes.*;

class MainClass {
	private static WeatherTower weatherTower;
	private static ArrayList<Flyable> activePlanes = new ArrayList<Flyable>();
	static ArrayList<String[]> PlaneList = new ArrayList<String[]> ();
	static CheckFileFormat cff = new CheckFileFormat();
	static NewPlane np = new NewPlane();
	static int sims = 0;
	
	public static void main(String[] args) {
		if (args.length > 0) {
			if(cff.FileReader(args[0]) == 1) {
				sims = cff.getIterations();
				PlaneList = cff.getPlaneList();
				for (int temp = 0; temp < PlaneList.size(); temp++) {
					Flyable singlePlane = np.newAircraft(PlaneList.get(temp)[0],
							PlaneList.get(temp)[1], Integer.parseInt(PlaneList.get(temp)[2]),
							Integer.parseInt(PlaneList.get(temp)[3]),
							Integer.parseInt(PlaneList.get(temp)[4])
					);
					activePlanes.add(singlePlane);
				}
				for (Flyable activePlane : activePlanes) {
					activePlane.registerTower(weatherTower);
				}
			}
		} else {
			System.out.println("No scenario file given");
		}
	}
}
