package coding1.ParkingLot;

public abstract class Vehicle {
    private String licensePlate;
    private int size;

    public Vehicle(String licensePlate, int size) {
        this.licensePlate = licensePlate;
        this.size = size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSize() {
        return size;
    }
}
