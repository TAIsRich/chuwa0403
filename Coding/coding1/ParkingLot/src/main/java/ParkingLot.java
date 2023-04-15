import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<ParkingSpot> spots;

    public ParkingLot(int numSpots) {
        spots = new ArrayList<ParkingSpot>();
        for (int i = 0; i < numSpots; i++) {
            spots.add(new ParkingSpot(i + 1));
        }
    }

    public ParkingSpot findAvailableSpot() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot;
            }
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot();
        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("Park " + vehicle.getLicensePlate() + " successful!");
            return true;
        }
        System.out.println("You cannot park the vehicle: " + vehicle.getLicensePlate() + ", because the parking lot " +
                "is full!");
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() != null && spot.getVehicle().equals(vehicle)) {
                spot.removeVehicle();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Vehicle> getParkedVehicles() {
        ArrayList<Vehicle> parkedVehicles = new ArrayList<Vehicle>();
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                parkedVehicles.add(spot.getVehicle());
            }
        }
        return parkedVehicles;
    }
}