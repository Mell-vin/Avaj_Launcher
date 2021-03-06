package avajlauncher.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CheckFileFormat {
	static ArrayList<String[]> PlaneList = new ArrayList<String[]>();
	static String[] temp = null;
	static FileReader fr = null;
	static BufferedReader br = null;
	public int iterations = 0;
	
	public void printList() {
		int i = 0;
		int j;
		
		while (i < PlaneList.size()) {
			j = 0;
			while (j < 5) {
				System.out.println(PlaneList.get(i)[j]);
				j++;
			}
			System.out.println("\n");
			i++;
		}
	}

	public int isNumeric(String str) {
        if (str == null){
            return 0;
        }
        try {
            int n = Integer.parseInt(str);
            if (n <= 0) {
                return -1;
            } else {
                return n;
            }
        } catch (Exception e) {
            return -2;
        }
    }
	
	public ArrayList<String[]> AirCraftList(String[] lineLength, ArrayList<String[]> PlaneList) {
		PlaneList.add(lineLength);
		return PlaneList;
	}
	
	public void createSim() {
		try {
	        File file = new File("simulation.txt");
	        if (file.createNewFile()){
	            System.out.println("New sim file created");
	        } else {
	            System.out.println("Deleting and re-creating simulation.txt\n");
	            file.delete();
	            file.createNewFile();
	        }
		} catch(IOException e) {
			System.out.println("Something went wrong in creating the sim file (''- )");
			System.exit(1);
		}
	}
	
	public String[] lineFormat(String line) {
		String[] LineLength = line.split("\\s");
		if (line.isBlank()) {
			//System.out.println("PEEP PEEP!!");
			return LineLength;
		}
		if (LineLength.length == 1) {
			System.out.println("I dont think I speak MD5 (''- )");
			System.exit(1);
		}
		if (LineLength.length != 5) {
			System.out.println("Improper line format (''- ) ");
			return null;
		} else if (LineLength[0].equals("JetPlane") == false && LineLength[0].equals("Helicopter") == false && LineLength[0].equals("Baloon") == false) {
			System.out.println("Improper plane names ( -'') (''- )");
			return null;
		} else if (isNumeric(LineLength[2]) == -2 || isNumeric(LineLength[3]) == -2 || isNumeric(LineLength[4]) == -2) {
			System.out.println("Coordinates/height are not integers (''- )");
			return null;
		}
		return LineLength;
	}
	
	public int FileReader(String FileName) {
		if(FileName != null) {
			try {
	            fr = new FileReader(FileName);
	            br = new BufferedReader(fr);
	            String line;

	            line = br.readLine();
	            iterations = isNumeric(line);
	            setIterations(iterations);
	            if (iterations == 0){
	                System.out.println("File empty... (''- )");
	            } else if (isNumeric(line) == -1) {
	                System.out.println("number is zero or negative (''- )");
	            } else if (isNumeric(line) == -2) {
	                System.out.println("First line isn't numerical (''- ) ");
	            } else {
	                while ((line = br.readLine()) != null) {
	                	temp = lineFormat(line);
	                    if(temp == null) {
	                    	fr.close();
	                        br.close();
	                    	return 0;
	                    } else if (temp.length == 1) {
	                    	continue;
	                    }
	                    else {
	                    	PlaneList = AirCraftList(temp, PlaneList);
	                    }
	                }
	                fr.close();
	                br.close();
	                return 1;
	            }
	        } catch (Exception e) {
	            System.out.println("There seems to be no airport (File not found) (''- ) ");
	            return 0;
	        }
		}
		return 0;
    }
	
	public int getIterations() {
		return this.iterations;
	}
	
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public ArrayList<String[]> getPlaneList() {
		return PlaneList;
	}
}
