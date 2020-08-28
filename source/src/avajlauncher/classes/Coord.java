package avajlauncher.classes;

public class Coord {
    private int longitude; //take note of the finality, can't be changed in case of errors later
    private int latitude;
    private int height;


    public Coord(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100) {
        	this.height = 100;
        } else {
        	this.height = height;
        }
    }


    public void setLongitude(int longitude) {
		this.longitude += longitude;
	}


	public void setLatitude(int latitude) {
		this.latitude += latitude;
	}


	public void setHeight(int height) {
		this.height += height;
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