package proxy;

import devices.SmartDevice;

public class SmartDeviceProxy {
    private SmartDevice device;
    private boolean canControl;

    public SmartDeviceProxy(SmartDevice device, boolean canControl) {
        this.device = device;
        this.canControl = canControl;
    }

    public void turnOn() {
        if (canControl) {
            device.turnOn();
        } else {
            System.out.println("You don't have permission to control this device.");
        }
    }

    public void turnOff() {
        if (canControl) {
            device.turnOff();
        } else {
            System.out.println("You don't have permission to control this device.");
        }
    }
}
