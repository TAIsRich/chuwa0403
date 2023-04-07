

import java.util.*;

public class ParkingLot {
    private Map<Integer, Vehicle> spots;
    private int capacity;
    private int numOccupied;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.numOccupied = 0;
        spots = new HashMap<>();
    }

    public boolean park(Vehicle vehicle, int spotNumber) {
        if (spotNumber < 1 || spotNumber > capacity) {
            return false;
        }

        if (spots.containsKey(spotNumber)) {
            return false;
        }

        spots.put(spotNumber, vehicle);
        numOccupied++;
        return true;
    }

    public boolean unpark(int spotNumber) {
        if (!spots.containsKey(spotNumber)) {
            return false;
        }

        spots.remove(spotNumber);
        numOccupied--;
        return true;
    }

    public int getNumOccupied() {
        return numOccupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return numOccupied == capacity;
    }
}

class Vehicle {
    private String licensePlate;
    private String make;
    private String model;

    public Vehicle(String licensePlate, String make, String model) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate, String make, String model) {
        super(licensePlate, make, model);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate, String make, String model) {
        super(licensePlate, make, model);
    }
}

