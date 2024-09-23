package system;

import devices.SmartDevice;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String roomName;
    private Map<String, SmartDevice> devices;

    public Room(String roomName) {
        this.roomName = roomName;
        this.devices = new HashMap<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
        System.out.println("Device added to room: " + roomName);
    }

    public void removeDevice(String deviceId) {
        if (devices.remove(deviceId) != null) {
            System.out.println("Device removed from room: " + roomName);
        } else {
            System.out.println("Device not found in this room.");
        }
    }

    public void turnOnAllDevices() {
        devices.values().forEach(SmartDevice::turnOn);
        System.out.println("All devices in " + roomName + " turned on.");
    }

    public void turnOffAllDevices() {
        devices.values().forEach(SmartDevice::turnOff);
        System.out.println("All devices in " + roomName + " turned off.");
    }

    public void reportRoomStatus() {
        System.out.println("Status of devices in room " + roomName + ":");
        devices.values().forEach(device -> System.out.println(device.getStatusReport()));
    }

    public SmartDevice getDevice(String deviceId) {
        return devices.get(deviceId);
    }
}
