
### `Design_Decisions.md`

```markdown
# Design Decisions for Design Patterns Project

This document explains the design decisions made for the implementation of various design patterns in this project.

## General Approach

1. **Modular Structure**: Each design pattern is implemented in a separate folder under `src/` for better organization and readability. This also makes it easier to expand the project by adding more patterns in the future.

2. **Real-World Examples**: For each pattern, real-world scenarios were chosen to make the implementation relatable. For example, the observer pattern uses a sensor and controller system similar to IoT applications in agriculture.

## Pattern-Specific Design Decisions

### 1. Observer Pattern
- **Scenario Chosen**: Soil moisture sensor and irrigation controller.
- **Reason**: This pattern fits well in a real-world IoT-like system where a sensor (subject) needs to notify controllers (observers) about changes in environmental conditions.
- **Design Choice**: Used an abstract `Subject` class to handle adding/removing observers and notifying them. The `SoilMoistureSensor` extends this class, while `IrrigationController` implements the `Observer` interface.

### 2. Command Pattern
- **Scenario Chosen**: A drone system where commands like takeoff, land, and capture photo are sent to the drone.
- **Reason**: The command pattern is ideal for this kind of scenario where multiple operations can be issued on the same receiver (drone).
- **Design Choice**: Commands were encapsulated in individual classes (`TakeOffCommand`, `LandCommand`, etc.), and a `DroneCommandDispatcher` was created as the invoker. This allows easy extension for additional commands without modifying existing code.

### 3. Singleton Pattern
- **Scenario Chosen**: A global drone fleet manager.
- **Reason**: In many applications, there’s a need for a single instance managing a global resource. In this case, a fleet of drones.
- **Design Choice**: Used a thread-safe implementation for the `DroneFleetManager` to ensure that only one instance of the manager is created, even in a multi-threaded environment.

### 4. Factory Pattern
- **Scenario Chosen**: A membership creation system where different types of memberships are generated (Free, Premium, Elite).
- **Reason**: The factory pattern is a perfect fit when you need to instantiate different types of objects based on certain conditions.
- **Design Choice**: A `MembershipFactory` class was designed to return the correct membership type based on the user’s input. This allows for easy addition of new membership types in the future without modifying existing code.

### 5. Decorator Pattern
- **Scenario Chosen**: Enhancing a wearable device (smartwatch) with additional functionalities like health tracking and GPS.
- **Reason**: The decorator pattern is ideal when you want to add responsibilities dynamically to an object. In this case, features were added to a smartwatch.
- **Design Choice**: A `WearableDecorator` was used as the base decorator class, and specific features (health tracking, GPS) were implemented as concrete decorators. This allows for any combination of features to be added to the base wearable device.

### 6. Adapter Pattern
- **Scenario Chosen**: Charging port adapter to allow a Lightning charger to work with a USB-C port.
- **Reason**: The adapter pattern is commonly used when two incompatible interfaces need to work together. In this case, different charging ports.
- **Design Choice**: A `ChargerAdapter` class was created to convert the `LightningCharger` interface to the `USBCCharger` interface. This allows seamless usage of different chargers without modifying existing charger classes.
