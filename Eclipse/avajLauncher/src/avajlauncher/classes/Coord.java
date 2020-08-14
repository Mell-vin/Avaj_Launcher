package avajlauncher.classes;

public class Coord {
    private int longitude; //take note of the finality, can't be changed in case of errors later
    private int latitude;
    private int height;


    protected Coord(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }


    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
	}
}