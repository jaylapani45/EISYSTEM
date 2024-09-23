package system;

import devices.SmartDevice;
import factory.SmartDeviceFactory;
import observer.DeviceEvent;
import observer.DeviceObserver;
import proxy.SmartDeviceProxy;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeHub implements DeviceObserver {
    private Map<String, SmartDevice> devices = new HashMap<>();
    private Map<String, SmartDeviceProxy> proxies = new HashMap<>();
    private Map<String, Map<String, SmartDevice>> rooms = new HashMap<>();

    public void addRoom(String roomName) {
        rooms.put(roomName, new HashMap<>());
        System.out.println("Room " + roomName + " has been added.");
    }

    public void addDeviceToRoom(String id, String type, String roomName) {
        SmartDevice device = SmartDeviceFactory.createDevice(id, type);
        SmartDeviceProxy proxy = new SmartDeviceProxy(device, true);
        devices.put(id, device);
        proxies.put(id, proxy);
        rooms.get(roomName).put(id, device);
        System.out.println(type + " with ID " + id + " has been added to " + roomName + ".");
        notifyObservers(new DeviceEvent(id, "added"));
    }

    public void turnOnDevice(String id) {
        SmartDeviceProxy proxy = proxies.get(id);
        if (proxy != null) {
            proxy.turnOn();
        } else {
            System.out.println("Device not found.");
        }
    }

    public void turnOffDevice(String id) {
        SmartDeviceProxy proxy = proxies.get(id);
        if (proxy != null) {
            proxy.turnOff();
        } else {
            System.out.println("Device not found.");
        }
    }

    public void reportDeviceStatus(String id) {
        SmartDevice device = devices.get(id);
        if (device != null) {
            System.out.println(device.getStatusReport());
        } else {
            System.out.println("Device not found.");
        }
    }

    public void turnOnAllDevicesInRoom(String roomName) {
        Map<String, SmartDevice> roomDevices = rooms.get(roomName);
        if (roomDevices != null) {
            roomDevices.values().forEach(SmartDevice::turnOn);
            System.out.println("All devices in " + roomName + " are now on.");
        } else {
            System.out.println("Room not found.");
        }
    }

    public void turnOffAllDevicesInRoom(String roomName) {
        Map<String, SmartDevice> roomDevices = rooms.get(roomName);
        if (roomDevices != null) {
            roomDevices.values().forEach(SmartDevice::turnOff);
            System.out.println("All devices in " + roomName + " are now off.");
        } else {
            System.out.println("Room not found.");
        }
    }

    public void reportRoomStatus(String roomName) {
        Map<String, SmartDevice> roomDevices = rooms.get(roomName);
        if (roomDevices != null) {
            roomDevices.values().forEach(device -> System.out.println(device.getStatusReport()));
        } else {
            System.out.println("Room not found.");
        }
    }

    // New method to report status of all devices
    public void reportStatus() {
        System.out.println("Device Status Report:");
        for (SmartDevice device : devices.values()) {
            System.out.println(device.getStatusReport());
        }
    }

    @Override
    public void update(String event) {
        System.out.println("Event received: " + event);
    }

    private void notifyObservers(DeviceEvent event) {
        update(event.toString());
    }
}
