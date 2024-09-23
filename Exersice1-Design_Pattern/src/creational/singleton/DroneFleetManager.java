package creational.singleton;
public class DroneFleetManager {
    private static DroneFleetManager instance;

    private DroneFleetManager() {}

    public static synchronized DroneFleetManager getInstance() {
        if (instance == null) {
            instance = new DroneFleetManager();
        }
        return instance;
    }

    public void manageFleet() {
        System.out.println("Managing drone fleet.");
    }
}
