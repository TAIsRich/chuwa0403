public class ParkingLot {
    private int totalSpots;
    private int availableSpots;

    public ParkingLot(int totalSpots) {
        this.totalSpots = totalSpots;
        this.availableSpots = totalSpots;
    }

    public boolean isFull() {
        return availableSpots == 0;
    }

    public boolean parkCar() {
        if (isFull()) {
            return false;
        }
        availableSpots--;
        return true;
    }

    public boolean leaveSpot() {
        if (availableSpots == totalSpots) {
            return false;
        }
        availableSpots++;
        return true;
    }
}
