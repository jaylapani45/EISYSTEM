
public class IrrigationController implements Observer {
    @Override
    public void update(String sensorData) {
        if (sensorData.equals("LOW")) {
            System.out.println("IrrigationController: Starting irrigation...");
        } else {
            System.out.println("IrrigationController: Moisture level is sufficient.");
        }
    }
}
