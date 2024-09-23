package creational.singleton;
public class SingletonPatternDemo {
    public static void main(String[] args) {
        DroneFleetManager fleetManager = DroneFleetManager.getInstance();
        fleetManager.manageFleet();
    }
}
