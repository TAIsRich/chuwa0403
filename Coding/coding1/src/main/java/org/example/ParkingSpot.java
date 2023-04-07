package org.example;

public class ParkingSpot {
    private final ParkingSpotType type;
    private boolean available;
    private Vehicle vehicle;
    private int spotNo;
    private Level level;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean canVehicleFit(Vehicle vehicle){
        return true;
    }

    public void takeSpot(Vehicle vehicle){
        available = false;
    }

    public void leaveSpot(Vehicle vehicle){
        available = true;
    }
}
