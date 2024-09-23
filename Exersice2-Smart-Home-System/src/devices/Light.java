package devices;

public class Light extends SmartDevice {
    public Light(String id) {
        super(id, "Light");
    }

    @Override
    public String getStatusReport() {
        return "Light " + getId() + " is " + (isOn() ? "On" : "Off") + ".";
    }
}
