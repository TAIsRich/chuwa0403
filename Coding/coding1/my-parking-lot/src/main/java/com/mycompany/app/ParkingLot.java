package com.mycompany.app;
import java.util.*;

public class ParkingLot
{
    private int capacity;
    private Map<Car, Integer> Cars;
    private Map<Integer, Car> parkingSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpots = new HashMap<>();
        this.Cars = new HashMap<>();
    }
    public boolean parkCar(Car car, int spotNumber) {
        if (spotNumber < 1 || spotNumber > capacity) {
            return false;
        }
        if (parkingSpots.containsKey(spotNumber)) {
            return false;
        }
        if (Cars.containsKey(car)) {
            return false;
        }
        Cars.put(car,spotNumber);
        parkingSpots.put(spotNumber, car);
        return true;
    }

    public boolean unparkCar(int spotNumber) {
        if (!parkingSpots.containsKey(spotNumber)) {
            return false;
        }
        Cars.remove(parkingSpots.get(spotNumber));
        parkingSpots.remove(spotNumber);

        return true;
    }
    public boolean unparkCar(Car car) {
        if (!Cars.containsKey(car)) {
            return false;
        }
        parkingSpots.remove(Cars.get(car));
        Cars.remove(car);

        return true;
    }

    public Map<Integer, Car> getParkingSpots() {
        return parkingSpots;
    }
}