package avajlauncher.classes;

abstract class Aircraft{
    protected long id;
    protected String name;
    protected Coord coordinates;
    private static long idCounter;


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

    public long getIdCounter() {
        return Aircraft.idCounter;
    }

    public void setIdCounter(long idCounter) {
        Aircraft.idCounter = idCounter;
    }

    protected Aircraft(String name, Coord coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    
    // private long nextId() {
    //     return this.id;
    // }

}