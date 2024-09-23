package structural.adapter;
public class AdapterPatternDemo {
    public static void main(String[] args) {
        USBCCharger usbcCharger = new USBCCharger();
        LightningCharger lightningCharger = new LightningCharger();

        System.out.println("Direct charging using USB-C:");
        usbcCharger.charge();

        System.out.println("\nCharging with adapter for Lightning:");
        ChargerAdapter adapter = new ChargerAdapter(lightningCharger);
        adapter.charge();
    }
}
