package devices;

public class DoorLock extends SmartDevice {
    public DoorLock(String id) {
        super(id, "DoorLock");
    }

    @Override
    public String getStatusReport() {
        return "DoorLock " + getId() + " is " + (isOn() ? "Locked" : "Unlocked") + ".";
    }
}
