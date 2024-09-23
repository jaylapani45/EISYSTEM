# Project Overview

This project demonstrates various design patterns in Java, including behavioral, creational, and structural patterns. It provides a comprehensive structure to help understand how different design patterns can be implemented and used in a software application.

## Table of Contents
- [Design Patterns Implemented](#design-patterns-implemented)
- [How to Run](#how-to-run)
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
   git clone https://github.com/jaylapani45/EISYSTEM.git

2. Navigate to the design pattern folder.
    cd /Exersice1-Design_Pattern/src

3. Compile and run any demo file:
    javac src/behavioral/observer/*.java
    java src/behavioral/observer/ObserverPatternDemo

Similarly, run other pattern demos in their respective folders.
