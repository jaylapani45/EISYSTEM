package structural.adapter;
public class USBCCharger implements ChargingPort {
    @Override
    public void charge() {
        System.out.println("Charging with USB-C.");
    }
}
