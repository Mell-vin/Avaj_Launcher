package avajlauncher.classes;

public class Tower {
    Flyable observers;

    public void updateConditions() {

    }

    public void register(Flyable flyable) {
    	observers = flyable;
    	System.out.println("Tower says: " + observers.getName() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {

    }

    protected void conditionsChanged() {
        
    }
    
}