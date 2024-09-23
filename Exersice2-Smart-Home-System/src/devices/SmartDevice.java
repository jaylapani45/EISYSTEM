package devices;

public abstract class SmartDevice {
    private String id;
    private String type;
    private boolean isOn;

    public SmartDevice(String id, String type) {
        this.id = id;
        this.type = type;
        this.isOn = false;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println(getType() + " " + getId() + " is turned on.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println(getType() + " " + getId() + " is turned off.");
    }

    public abstract String getStatusReport();
}
