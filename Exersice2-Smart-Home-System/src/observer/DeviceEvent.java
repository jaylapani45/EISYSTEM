package observer;

public class DeviceEvent {
    private String deviceId;
    private String action;

    public DeviceEvent(String deviceId, String action) {
        this.deviceId = deviceId;
        this.action = action;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Device " + deviceId + " performed action: " + action;
    }
}
