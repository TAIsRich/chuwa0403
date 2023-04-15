import java.util.*;

public class ParkingLot {
    private int numFloors;
    private LinkedList<ParkingSpot> availableSpots;
    private Map<String, Vehicle> parkedVehicles;

    public ParkingLot(int numFloors, int spotsPerFloor) {
        this.numFloors = numFloors;
        this.availableSpots = new LinkedList<>();
        this.parkedVehicles = new HashMap<>();

        for (int floor = 0; floor < numFloors; floor++) {
            for (int spotNum = 0; spotNum < spotsPerFloor; spotNum++) {
                ParkingSpot spot = new ParkingSpot(floor, spotNum);
                availableSpots.add(spot);
            }
        }
    }

    public String parkVehicle(String licensePlate) {
        if (availableSpots.isEmpty()) {
            return "Parking lot full";
        }

        Vehicle vehicle = new Vehicle(licensePlate);
        ParkingSpot spot = availableSpots.removeFirst();

        parkedVehicles.put(vehicle.getLicensePlate(), vehicle);
        spot.parkVehicle(vehicle);
        vehicle.setParkingSpot(spot);

        return "Please proceed to " + String.valueOf(spot.getFloor()) + " floor and park in " + String.valueOf(spot.getSpotNum()) + "spot";
    }

    public String unparkVehicle(String licensePlate) {
        Vehicle vehicle = parkedVehicles.get(licensePlate);
        ParkingSpot spot = vehicle.getParkingSpot();

        if (vehicle == null || spot == null) {
            return "Unable to find vehicle or spot number, failed to checkout";
        }

        spot.unparkVehicle();
        vehicle.setParkingSpot(null);
        parkedVehicles.remove(licensePlate);
        availableSpots.addFirst(spot);
        return "Check out successful, thank you for visiting";
    }

    public int getNumFloors() {
        return numFloors;
    }

    public List<ParkingSpot> getAvailableSpots() {
        return availableSpots;
    }

    public Map<String, Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }
}