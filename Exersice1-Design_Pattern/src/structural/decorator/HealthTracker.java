package structural.decorator;
public class HealthTracker extends WearableDecorator {
    public HealthTracker(WearableDevice device) {
        super(device);
    }

    @Override
    public void features() {
        super.features();
        System.out.println("Adding health tracking features.");
    }
}
