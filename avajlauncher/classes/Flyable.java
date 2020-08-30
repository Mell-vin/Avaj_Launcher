package avajlauncher.classes;

public interface Flyable {
    public void updateConditions ();
    public void registerTower(WeatherTower weatherTower);
    public String getName();
    public String getType();
    public long getId();
    public void writeToFile(String string);
    public Coord getCoordinates();
}