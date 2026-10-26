# Assignment 5 — Strategy Pattern (Navigation / Route Planning)

## Overview
This repository implements the **Strategy** behavioral design pattern in Java (JDK 17) for **Option A: Navigation / Route Planning**.

The `Navigator` (Context) delegates route calculation to interchangeable `RouteStrategy` implementations without containing any conditional branching (`if/else` or `switch`) on transport modes:
* `CarRouteStrategy` — calculates driving time considering average speed, fuel cost per km, and traffic delay.
* `WalkRouteStrategy` — calculates walking time applying pedestrian courtyard shortcuts at zero cost.
* `CycleRouteStrategy` — calculates cycling duration along bike lanes with a flat bike-share unlock fee.
* `PublicTransportStrategy` — demonstrates Open/Closed extensibility by adding bus transit calculation without modifying `Navigator` or existing strategies.

## Project Structure
* `src/RouteStrategy.java` — Strategy interface declaring `buildRoute(...)`.
* `src/RouteResult.java` — Immutable value object holding calculated route details.
* `src/CarRouteStrategy.java` — Concrete Strategy 1.
* `src/WalkRouteStrategy.java` — Concrete Strategy 2.
* `src/CycleRouteStrategy.java` — Concrete Strategy 3.
* `src/PublicTransportStrategy.java` — Concrete Strategy 4 (Extensibility demonstration).
* `src/Navigator.java` — Context class holding a reference to `RouteStrategy`.
* `src/Main.java` — Client demonstrating runtime strategy switching.

## How to Build and Run
### Prerequisites
* Java Development Kit (JDK) 17

### Run via Terminal
1. Compile all source files:
   javac -d out src/*.java
2. Run the client:
   java -cp out Main

## How to Add a New Strategy
Thanks to the Open/Closed Principle, adding a new route calculation algorithm requires zero changes to `Navigator` or existing strategies:
1. Create a new class (e.g., `src/ScooterRouteStrategy.java`) that implements `RouteStrategy`.
2. Implement the `buildRoute(String origin, String destination, double distanceKm)` method with your custom speed and pricing formula.
3. Pass an instance of the new strategy into `navigator.setStrategy(new ScooterRouteStrategy())` in the client code.