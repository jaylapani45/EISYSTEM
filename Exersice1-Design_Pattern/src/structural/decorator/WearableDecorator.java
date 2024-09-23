package structural.decorator;
public abstract class WearableDecorator implements WearableDevice {
    protected WearableDevice device;

    public WearableDecorator(WearableDevice device) {
        this.device = device;
    }

    @Override
    public void features() {
        device.features();
    }
}
