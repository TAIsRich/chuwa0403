package coding1.ParkingLot;

public class ParkingSpot {
    private int number;
    private boolean occupied;
    private int size;
    private Vehicle vehicle;

    public ParkingSpot(int number) {
        this.number = number;
        this.occupied = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }
}
