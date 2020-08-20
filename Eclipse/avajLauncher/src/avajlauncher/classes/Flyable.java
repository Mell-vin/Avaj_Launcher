package avajlauncher.classes;

public interface Flyable {
    public void updateConditions ();
    public void registerTower(WeatherTower weatherTower);
    public void PrintInfo();
    public String getName();
}