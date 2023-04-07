package Coding.ParkingLot;

public class Vehicle {
    private String plateLicence;
    private int size = 1;
    private ParkingSpot parkingSpot;


    public Vehicle(int size) {
        this.size = size;
    }

    public Vehicle(String plateLicence, int size) {
        this.plateLicence = plateLicence;
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setPlateLicence(String plateLicence) {
        this.plateLicence = plateLicence;
    }

    public String getPlateLicence() {
        return plateLicence;
    }

    public boolean isParked() {
        return parkingSpot != null;
    }

    public ParkingSpot getParkingSpot() {
        if (!isParked())
            return null;
        else
            return parkingSpot;
    }

    public boolean park(ParkingSpot parkingSpot) {
        if (parkingSpot.isAvailable() && parkingSpot.getSize() <= this.size) {
            this.parkingSpot = parkingSpot;
            this.parkingSpot.setAvailable(false);
            return true;
        }
        return false;
    }

    public void remove() {
        if (!isParked())
            return;

        this.parkingSpot.setAvailable(true);
        this.parkingSpot = null;
    }
}
