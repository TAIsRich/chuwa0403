public class ParkingLot {
    private List<ParkingSpace> slots;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            slots.add(new ParkingSpace());
        }
    }

    public boolean Park(Vehicle vehicle) {
        for (ParkingSpace space : slots) {
            if (!space.isOccupied()) {
                space.setVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean Unpark(Vehicle vehicle) {
        for (ParkingSpace space : slots) {
            if (space.isOccupied() && space.getVehicle().equals(vehicle)) {
                space.setVehicle(null);
                return true;
            }
        }
        return false;
    }

    public boolean IsFull() {
        for (ParkingSpace space : slots) {
            if (!space.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    public int AvailableSpaces() {
        int count = 0;
        for (ParkingSpace space : slots) {
            if (!space.isOccupied()) {
                count++;
            }
        }
        return count;
    }
}

public class ParkingSpace {
    private boolean occupied;
    private Vehicle vehicle;

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        occupied = (vehicle != null);
    }
}

public class Vehicle {

    private String make;
    private String model;
    private String licensePlate;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Vehicle(String type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }

}
