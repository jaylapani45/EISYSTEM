package structural.decorator;
public class GPSModule extends WearableDecorator {
    public GPSModule(WearableDevice device) {
        super(device);
    }

    @Override
    public void features() {
        super.features();
        System.out.println("Adding GPS tracking.");
    }
}
