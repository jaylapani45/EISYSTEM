# Project Overview

This project demonstrates various design patterns in Java, including behavioral, creational, and structural patterns. It provides a comprehensive structure to help understand how different design patterns can be implemented and used in a software application.

## Table of Contents
- [Project Structure](#project-structure)
- [Design Patterns Implemented](#design-patterns-implemented)
- [How to Run](#how-to-run)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

/Project1-DesignPatterns/
│
├── /src/
│   ├── /behavioral/
│   │   ├── /observer/
│   │   │   ├── Observer.java                  # Observer Interface
│   │   │   ├── Subject.java                   # Subject Interface
│   │   │   ├── SoilMoistureSensor.java        # Concrete Subject (Observable)
│   │   │   ├── IrrigationController.java      # Concrete Observer
│   │   │   └── ObserverPatternDemo.java       # Main class to test Observer pattern
│   │   ├── /command/
│   │   │   ├── Command.java                   # Command Interface
│   │   │   ├── TakeOffCommand.java            # Concrete Command for TakeOff
│   │   │   ├── LandCommand.java               # Concrete Command for Landing
│   │   │   ├── CapturePhotoCommand.java       # Concrete Command for Capturing Photo
│   │   │   ├── Drone.java                     # Receiver class (Drone)
│   │   │   ├── DroneCommandDispatcher.java    # Invoker class (Command Dispatcher)
│   │   │   └── CommandPatternDemo.java        # Main class to test Command pattern
│
│   ├── /creational/
│   │   ├── /singleton/
│   │   │   ├── DroneFleetManager.java         # Singleton class for global fleet management
│   │   │   └── SingletonPatternDemo.java      # Main class to test Singleton pattern
│   │   ├── /factory/
│   │   │   ├── MembershipFactory.java         # Factory class to create different Membership types
│   │   │   ├── Membership.java                # Interface for Membership
│   │   │   ├── FreeMembership.java            # Concrete class for Free Membership
│   │   │   ├── PremiumMembership.java         # Concrete class for Premium Membership
│   │   │   ├── EliteMembership.java           # Concrete class for Elite Membership
│   │   │   └── FactoryPatternDemo.java        # Main class to test Factory pattern
│
│   ├── /structural/
│   │   ├── /decorator/
│   │   │   ├── WearableDevice.java            # Interface for a Wearable Device
│   │   │   ├── Smartwatch.java                # Concrete Wearable Device (Smartwatch)
│   │   │   ├── WearableDecorator.java         # Abstract Decorator class
│   │   │   ├── HealthTracker.java             # Concrete Decorator for adding health tracking features
│   │   │   ├── GPSModule.java                 # Concrete Decorator for adding GPS tracking
│   │   │   └── DecoratorPatternDemo.java      # Main class to test Decorator pattern
│   │   ├── /adapter/
│   │   │   ├── ChargingPort.java              # Interface for Charging Port
│   │   │   ├── USBCCharger.java               # Concrete USBC Charger
│   │   │   ├── LightningCharger.java          # Concrete Lightning Charger
│   │   │   ├── ChargerAdapter.java            # Adapter class to make Lightning work with USBC
│   │   │   └── AdapterPatternDemo.java        # Main class to test Adapter pattern
│
├── /docs/                                      # Documentation for patterns, setup, and usage
│   ├── README.md                               # Main readme for the project
│   └── Design_Decisions.md                     # Detailed explanations of design decisions


## Design Patterns Implemented

### 1. Behavioral Patterns
- **Observer Pattern**: Demonstrated through a `SoilMoistureSensor` that notifies the `IrrigationController` about changes in moisture levels.
- **Command Pattern**: Implemented using a `Drone` as a receiver and commands like `TakeOff`, `Land`, and `CapturePhoto`.

### 2. Creational Patterns
- **Singleton Pattern**: Used for the `DroneFleetManager` to manage a global instance of drone fleets.
- **Factory Pattern**: Handles the creation of different types of `Membership` (Free, Premium, and Elite).

### 3. Structural Patterns
- **Decorator Pattern**: Applied to a `WearableDevice` (Smartwatch) to add functionalities like GPS and health tracking.
- **Adapter Pattern**: Allows compatibility between different charging ports (USB-C and Lightning).

## How to Run

1. Clone this repository.
   ```bash
   git clone <your-repo>

2. Navigate to the design pattern folder.
    cd /Exersice1-Design_Pattern/src

3. Compile and run any demo file:
    javac src/behavioral/observer/*.java
    java src/behavioral/observer/ObserverPatternDemo

Similarly, run other pattern demos in their respective folders.
