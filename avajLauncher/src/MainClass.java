import avajlauncher.classes.CheckFileFormat;

class MainClass {
	static CheckFileFormat cff = new CheckFileFormat();
	
	public static void main(String[] args) {
		if(cff.FileReader("scenario.txt") == 1) {
			cff.printList();
		}
	}
}