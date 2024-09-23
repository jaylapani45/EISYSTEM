package structural.decorator;
public class Smartwatch implements WearableDevice {
    @Override
    public void features() {
        System.out.println("Basic smartwatch features.");
    }
}
