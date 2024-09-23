
public class ObserverPatternDemo {
    public static void main(String[] args) {
        SoilMoistureSensor sensor = new SoilMoistureSensor();
        IrrigationController controller = new IrrigationController();

        sensor.addObserver(controller);
        
        // Simulate moisture level changes
        sensor.setMoistureLevel("LOW");
        sensor.setMoistureLevel("HIGH");
    }
}
