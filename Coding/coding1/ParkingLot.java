package coding1;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum ParkingStatus {EMPTY, OCCUPIED}
enum VehicleType {BIKE, COMPACT, SEDAN, TRUCK}
enum SlotSize {SMALL, MEDIUM, LARGE}

class ParkingController {
    private Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, ParkingLot parkingLot) {
        vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(vehicle, parkingLot, new Date(), null));
    }

    private void onVehicleExit(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        parkingDetails.exitTime = new Date();
    }
}


public class ParkingLot {
    private String parkingLotId;
    private List<Floor> floors;
    private String parkingLotName;
    private String address;

    public ParkingLot(String parkingLotId, List<Floor> floors, String parkingLotName, String address) {
        this.parkingLotId = parkingLotId;
        this.floors = floors;
        this.parkingLotName = parkingLotName;
        this.address = address;
    }

    private void emptyWholeParkingLot() {
        for (Floor floor : floors) {
            floor.emptyFloor();
        }
    }
}

class ParkingDetails {
    Vehicle vehicle;
    ParkingLot parkingLot;
    Date entryTime;
    Date exitTime;

    public ParkingDetails(Vehicle vehicle, ParkingLot parkingLot, Date entryTime, Date exitTime) {
        this.vehicle = vehicle;
        this.parkingLot = parkingLot;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}

class ParkingSlot {
    private String slotId;
    private String slotNumber;
    private ParkingStatus status;
    private SlotSize slotSize;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, String slotNumber, ParkingStatus status, SlotSize slotSize) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.status = status;
        this.slotSize = slotSize;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (isVehicleParkingPossible(vehicle)) {
            this.vehicle = vehicle;
            this.status = ParkingStatus.OCCUPIED;
        } else {
            throw new IllegalArgumentException("cannot park");
        }
    }

    public void emptySlot() {
        this.vehicle = null;
        status = ParkingStatus.EMPTY;
    }

    private boolean isVehicleParkingPossible(Vehicle vehicle) {
        return true;
    }
}

class Floor {
    private String floorId;
    private int floorNumber;
    private String floorName;
    private List<ParkingSlot> parkingSlots;


    public Floor(String floorId, int floorNumber, String floorName, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.parkingSlots = parkingSlots;
    }

    public void emptyFloor() {
        for (ParkingSlot slot: parkingSlots) {
            slot.emptySlot();
        }
    }
}

abstract class Vehicle {
    protected VehicleType type;
    protected String carNumber;
    public Vehicle(VehicleType type, String carNumber) {
        this.type = type;
        this.carNumber = carNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
class Bike extends Vehicle {
    public Bike(String carNumber) {
        super(VehicleType.BIKE, carNumber);
    }
}
class Compact extends Vehicle {
    public Compact(String carNumber) {
        super(VehicleType.COMPACT, carNumber);
    }
}
class Sedan extends Vehicle {
    public Sedan(String carNumber) {
        super(VehicleType.SEDAN, carNumber);
    }
}
class Truck extends Vehicle {
    public Truck(String carNumber) {
        super(VehicleType.TRUCK, carNumber);
    }
}