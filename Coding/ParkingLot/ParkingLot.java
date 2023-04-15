package Coding.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private int occupancy;
    private ParkingSpot[] spots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupancy = 0;
        this.spots = new ParkingSpot[capacity];

        for (int i = 0; i < capacity; i++)
            spots[i] = new ParkingSpot(i);
    }

    public boolean park(Vehicle vehicle, ParkingSpot parkingSpot) {
        if (occupancy == capacity || !vehicle.park(parkingSpot))
            return false;

        occupancy++;
        return true;
    }

    public boolean remove(Vehicle vehicle) {
        if (!vehicle.isParked())
            return false;

        vehicle.remove();
        occupancy--;
        return true;
    }

    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        return vehicle.getParkingSpot();
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}
