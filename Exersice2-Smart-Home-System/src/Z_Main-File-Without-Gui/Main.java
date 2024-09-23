import system.SmartHomeHub;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scanner scanner = new Scanner(System.in);

        // Adding some rooms
        hub.addRoom("Living Room");
        hub.addRoom("Bedroom");

        // Adding devices to rooms
        hub.addDeviceToRoom("1", "light", "Living Room");
        hub.addDeviceToRoom("2", "thermostat", "Bedroom");
        hub.addDeviceToRoom("3", "door", "Living Room");

        // Command loop
        while (true) {
            System.out.println("\nEnter Command (on, off, status, roomOn, roomOff, roomStatus, exit): ");
            String command = scanner.nextLine().trim();
            
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Smart Home System.");
                break;
            }

            processCommand(command, hub, scanner);
        }
        scanner.close();
    }

    private static void processCommand(String command, SmartHomeHub hub, Scanner scanner) {
        switch (command.toLowerCase()) {
            case "on":
                System.out.print("Enter Device ID to turn on: ");
                String idToTurnOn = scanner.nextLine().trim();
                hub.turnOnDevice(idToTurnOn);
                break;
            case "off":
                System.out.print("Enter Device ID to turn off: ");
                String idToTurnOff = scanner.nextLine().trim();
                hub.turnOffDevice(idToTurnOff);
                break;
            case "status":
                System.out.print("Enter Device ID to view status: ");
                String idToViewStatus = scanner.nextLine().trim();
                hub.reportDeviceStatus(idToViewStatus);
                break;
            case "roomon":
                System.out.print("Enter Room Name to turn on all devices: ");
                String roomToTurnOn = scanner.nextLine().trim();
                hub.turnOnAllDevicesInRoom(roomToTurnOn);
                break;
            case "roomoff":
                System.out.print("Enter Room Name to turn off all devices: ");
                String roomToTurnOff = scanner.nextLine().trim();
                hub.turnOffAllDevicesInRoom(roomToTurnOff);
                break;
            case "roomstatus":
                System.out.print("Enter Room Name to view status: ");
                String roomName = scanner.nextLine().trim();
                hub.reportRoomStatus(roomName);
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
}
