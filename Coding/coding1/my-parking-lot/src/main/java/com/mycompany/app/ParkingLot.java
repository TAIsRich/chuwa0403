package com.mycompany.app;
import java.util.*;

public class ParkingLot
{
    private int capacity;
    private Map<Integer, Car> parkingSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpots = new HashMap<>();
    }
    public boolean parkCar(Car car, int spotNumber) {
        if (spotNumber < 1 || spotNumber > capacity) {
            return false;
        }
        if (parkingSpots.containsKey(spotNumber)) {
            return false;
        }
        parkingSpots.put(spotNumber, car);
        return true;
    }

    public boolean unparkCar(int spotNumber) {
        if (!parkingSpots.containsKey(spotNumber)) {
            return false;
        }
        parkingSpots.remove(spotNumber);
        return true;
    }

    public Map<Integer, Car> getParkingSpots() {
        return parkingSpots;
    }
}