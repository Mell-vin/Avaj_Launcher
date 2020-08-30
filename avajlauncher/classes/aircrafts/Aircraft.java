package avajlauncher.classes.aircrafts;
import java.io.*;   // Import the FileWriter class
import java.io.IOException;
import avajlauncher.classes.Coord;

abstract class Aircraft extends AircraftFactory{
    protected long id = 0;
    protected String name;
    protected String type;
    protected Coord coordinates;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public String getType() {
    	return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    protected Aircraft(String name, String type, Coord coordinates, long id) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
        this.id = id;
    }
    
    public void writeToFile(String string) {
    	try {
    		File file = new File("simulation.txt");
    		FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.println(string);
            pr.close();
            br.close();
            fr.close();
    	}catch (IOException e) {
    		System.out.println("Oops. An error occurred when writing to file (''- )");
    	}
    }
    
     private long nextId(long id) { //gonna use this to create the plane IDs
    	 this.setId(id);
         return this.id;
     }

}