import system.SmartHomeHub;
import javax.swing.*;
import java.awt.*;

public class MainGUI {
    private static SmartHomeHub hub = new SmartHomeHub();
    private static JTextArea consoleArea = new JTextArea(15, 50);
    private static DefaultListModel<String> deviceListModel = new DefaultListModel<>();
    private static JList<String> deviceList = new JList<>(deviceListModel);
    
    public static void main(String[] args) {
        // Setup the main window
        JFrame frame = new JFrame("Smart Home System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.setLayout(new BorderLayout());

        // Initialize the hub with some devices
        initializeDevices();

        // Create control panel with a nicer look
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.LIGHT_GRAY);
        controlPanel.setBorder(BorderFactory.createTitledBorder("Control Panel"));
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Room controls
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(new JLabel("Room Name:"), gbc);
        JTextField roomField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(roomField, gbc);
        JButton addRoomButton = new JButton("Add Room");
        gbc.gridx = 2;
        controlPanel.add(addRoomButton, gbc);

        // Device controls
        gbc.gridx = 0;
        gbc.gridy = 1;
        controlPanel.add(new JLabel("Device ID:"), gbc);
        JTextField deviceIdField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(deviceIdField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        controlPanel.add(new JLabel("Device Type:"), gbc);
        JTextField deviceTypeField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(deviceTypeField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        controlPanel.add(new JLabel("Room for Device:"), gbc);
        JTextField deviceRoomField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(deviceRoomField, gbc);
        JButton addDeviceButton = new JButton("Add Device");
        gbc.gridx = 2;
        controlPanel.add(addDeviceButton, gbc);

        // Device control buttons
        gbc.gridx = 0;
        gbc.gridy = 4;
        controlPanel.add(new JLabel("Control Device ID:"), gbc);
        JTextField controlDeviceIdField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(controlDeviceIdField, gbc);
        JButton turnOnButton = new JButton("Turn On");
        gbc.gridx = 2;
        controlPanel.add(turnOnButton, gbc);
        JButton turnOffButton = new JButton("Turn Off");
        gbc.gridx = 3;
        controlPanel.add(turnOffButton, gbc);

        // Room control buttons
        gbc.gridx = 0;
        gbc.gridy = 5;
        controlPanel.add(new JLabel("Control Room Name:"), gbc);
        JTextField controlRoomField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(controlRoomField, gbc);
        JButton roomOnButton = new JButton("Turn On All in Room");
        gbc.gridx = 2;
        controlPanel.add(roomOnButton, gbc);
        JButton roomOffButton = new JButton("Turn Off All in Room");
        gbc.gridx = 3;
        controlPanel.add(roomOffButton, gbc);

        // Status viewing buttons
        gbc.gridx = 0;
        gbc.gridy = 6;
        JButton viewStatusButton = new JButton("View Status of All Devices");
        controlPanel.add(viewStatusButton, gbc);
        
        gbc.gridy = 7;
        controlPanel.add(new JLabel("Device ID for Status:"), gbc);
        JTextField deviceStatusField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(deviceStatusField, gbc);
        JButton viewDeviceStatusButton = new JButton("View Device Status");
        gbc.gridx = 2;
        controlPanel.add(viewDeviceStatusButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        controlPanel.add(new JLabel("Room Name for Status:"), gbc);
        JTextField roomStatusField = new JTextField(10);
        gbc.gridx = 1;
        controlPanel.add(roomStatusField, gbc);
        JButton viewRoomStatusButton = new JButton("View Room Status");
        gbc.gridx = 2;
        controlPanel.add(viewRoomStatusButton, gbc);

        // Add components to the frame
        frame.getContentPane().add(BorderLayout.WEST, controlPanel);

        // Device list area
        deviceList.setBorder(BorderFactory.createTitledBorder("Current Devices"));
        JScrollPane deviceScrollPane = new JScrollPane(deviceList);
        deviceScrollPane.setPreferredSize(new Dimension(250, 400));
        frame.getContentPane().add(BorderLayout.CENTER, deviceScrollPane);

        // Console area for showing logs
        consoleArea.setEditable(false);
        consoleArea.setBorder(BorderFactory.createTitledBorder("Console Output"));
        JScrollPane consoleScrollPane = new JScrollPane(consoleArea);
        frame.getContentPane().add(BorderLayout.SOUTH, consoleScrollPane);

        // Add action listeners for buttons
        addRoomButton.addActionListener(e -> {
            String roomName = roomField.getText().trim();
            if (!roomName.isEmpty()) {
                hub.addRoom(roomName);
                appendToConsole("Room added: " + roomName);
            }
        });

        addDeviceButton.addActionListener(e -> {
            String deviceId = deviceIdField.getText().trim();
            String deviceType = deviceTypeField.getText().trim();
            String roomName = deviceRoomField.getText().trim();
            if (!deviceId.isEmpty() && !deviceType.isEmpty() && !roomName.isEmpty()) {
                hub.addDeviceToRoom(deviceId, deviceType, roomName);
                deviceListModel.addElement(deviceType + " (ID: " + deviceId + ") in " + roomName);
                appendToConsole("Device added: " + deviceType + " with ID " + deviceId + " to room " + roomName);
            }
        });

        turnOnButton.addActionListener(e -> {
            String deviceId = controlDeviceIdField.getText().trim();
            if (!deviceId.isEmpty()) {
                hub.turnOnDevice(deviceId);
                appendToConsole("Device " + deviceId + " turned on.");
            }
        });

        turnOffButton.addActionListener(e -> {
            String deviceId = controlDeviceIdField.getText().trim();
            if (!deviceId.isEmpty()) {
                hub.turnOffDevice(deviceId);
                appendToConsole("Device " + deviceId + " turned off.");
            }
        });

        roomOnButton.addActionListener(e -> {
            String roomName = controlRoomField.getText().trim();
            if (!roomName.isEmpty()) {
                hub.turnOnAllDevicesInRoom(roomName);
                appendToConsole("All devices in room " + roomName + " turned on.");
            }
        });

        roomOffButton.addActionListener(e -> {
            String roomName = controlRoomField.getText().trim();
            if (!roomName.isEmpty()) {
                hub.turnOffAllDevicesInRoom(roomName);
                appendToConsole("All devices in room " + roomName + " turned off.");
            }
        });

        viewStatusButton.addActionListener(e -> {
            appendToConsole("Device Status:");
            hub.reportStatus();
        });

        viewDeviceStatusButton.addActionListener(e -> {
            String deviceId = deviceStatusField.getText().trim();
            if (!deviceId.isEmpty()) {
                hub.reportDeviceStatus(deviceId);
            }
        });

        viewRoomStatusButton.addActionListener(e -> {
            String roomName = roomStatusField.getText().trim();
            if (!roomName.isEmpty()) {
                hub.reportRoomStatus(roomName);
            }
        });

        // Display the window
        frame.setVisible(true);
    }

    // Method to append text to the console
    private static void appendToConsole(String message) {
        consoleArea.append(message + "\n");
        consoleArea.setCaretPosition(consoleArea.getDocument().getLength());
    }

    // Initialize the hub with some devices
    private static void initializeDevices() {
        hub.addRoom("Living Room");
        hub.addRoom("Bedroom");
        hub.addDeviceToRoom("1", "Light", "Living Room");
        hub.addDeviceToRoom("2", "Thermostat", "Bedroom");
        hub.addDeviceToRoom("3", "Door", "Living Room");
        deviceListModel.addElement("Light (ID: 1) in Living Room");
        deviceListModel.addElement("Thermostat (ID: 2) in Bedroom");
        deviceListModel.addElement("Door (ID: 3) in Living Room");
    }
}
