package avajlauncher.classes;

abstract class Aircraft extends AircraftFactory{
    protected long id;
    protected String name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    protected Aircraft(String name, Coord coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    
    // private long nextId() { //gonna use this to create the plane IDs
    //     return this.id;
    // }

}