public class ParkingSpot {
    private int floor;
    private int spotNum;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int floor, int spotNum) {
        this.floor = floor;
        this.spotNum = spotNum;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
        vehicle.setParkingSpot(this);
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}