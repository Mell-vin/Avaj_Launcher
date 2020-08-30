package avajlauncher.classes;

public class Tower {
    Flyable observers;

    public void register(Flyable flyable) {
    	observers = flyable;
    	String string = "Tower says: "
    			+ observers.getType()
    			+ "#" + observers.getName()
    			+ " (#*" + observers.getId()
    			+ "&$%) registered to weather tower."
    	;
    	observers.writeToFile(string);
    	System.out.println(string);
    }

    public void unregister(Flyable flyable) {
    	observers = flyable;
    	String string = "Tower says: "
    			+ observers.getType()
    			+ "#" + observers.getName()
    			+ " (#*" + observers.getId()
    			+ "&$%) unregistered from weather tower."
    	;
    	observers.writeToFile(string + "\nLatitude: "
    	+ observers.getCoordinates().getLatitude()
    	+ "\nLongitude: "
    	+ observers.getCoordinates().getLongitude()
    	+ "\nheight: "
    	+ observers.getCoordinates().getHeight());
    	System.out.println(string);
    }

    protected void conditionsChanged() {
        
    }
}