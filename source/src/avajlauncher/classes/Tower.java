package avajlauncher.classes;

public class Tower {
    Flyable observers;

    public void register(Flyable flyable) {
    	observers = flyable;
    	System.out.println("Tower says: "
    			+ observers.getType()
    			+ "#" + observers.getName()
    			+ " (#*" + observers.getId()
    			+ "&$%) registered to weather tower."
    	);
    }

    public void unregister(Flyable flyable) {
    	observers = flyable;
    	System.out.println("Tower says: "
    			+ observers.getType()
    			+ "#" + observers.getName()
    			+ " (#*" + observers.getId()
    			+ "&$%) unregistered from weather tower."
    	);
    }

    protected void conditionsChanged() {
        
    }
}