package coding1.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spots = new ArrayList<ParkingSpot>();
        for (int i = 0; i < capacity; i++) {
            ParkingSpot spot = new ParkingSpot(i);
            spots.add(spot);
        }
    }

    public boolean isFull() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        if (isFull()) {
            return null;
        }
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getSize() >= vehicle.getSize()) {
                spot.park(vehicle);
                return spot;
            }
        }
        return null;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == vehicle) {
                spot.removeVehicle();
                return true;
            }
        }
        return false;
    }
}

