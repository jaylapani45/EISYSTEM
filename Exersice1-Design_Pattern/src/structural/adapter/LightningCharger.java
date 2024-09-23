package structural.adapter;
public class LightningCharger implements ChargingPort {
    @Override
    public void charge() {
        System.out.println("Charging with Lightning connector.");
    }
}
