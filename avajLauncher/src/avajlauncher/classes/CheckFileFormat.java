package avajlauncher.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CheckFileFormat {
	
	static ArrayList<String[]> PlaneList = new ArrayList<String[]>();
	static String[] temp = null;
	static FileReader fr = null;
	static BufferedReader br = null;
	static int iterations = 0;
	
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
            	iterations = n;
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
	
	public String[] lineFormat(String line) {
		String[] LineLength = line.split(" ");
		if (LineLength.length != 5) {
			System.out.println("Improper line format");
			return null;
		} else if (LineLength[0].equals("JetPlane") == false && LineLength[0].equals("Helicopter") == false && LineLength[0].equals("Baloon") == false) {
			System.out.println("Improper plane names");
			return null;
		} else if (isNumeric(LineLength[2]) == -2 || isNumeric(LineLength[3]) == -2 || isNumeric(LineLength[4]) == -2) {
			System.out.println("Coordinates/height are not integers");
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
	            if (iterations == 0){
	                System.out.println("File empty...");
	            } else if (isNumeric(line) == -1) {
	                System.out.println("number is zero or negative");
	            } else if (isNumeric(line) == -2) {
	                System.out.println("First line isn't numerical");
	            } else {
	                while ((line = br.readLine()) != null) {
	                	temp = lineFormat(line);
	                    if(temp == null) {
	                    	fr.close();
	                        br.close();
	                    	return 0;
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
	            System.out.println("File not found");
	            e.printStackTrace();
	            return 0;
	        }
		}
		return 0;
    }
}
