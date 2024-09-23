package structural.adapter;
public class ChargerAdapter implements ChargingPort {
    private LightningCharger lightningCharger;

    public ChargerAdapter(LightningCharger lightningCharger) {
        this.lightningCharger = lightningCharger;
    }

    @Override
    public void charge() {
        System.out.println("Using Adapter...");
        lightningCharger.charge();
    }
}
