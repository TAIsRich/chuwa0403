public class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.occupied = false;
        this.vehicle = null;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}