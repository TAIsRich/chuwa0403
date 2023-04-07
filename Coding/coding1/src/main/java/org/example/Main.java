package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Vehicle {
    private int vehicleSize;

    protected int getVehicleSize() {
        return vehicleSize;
    }

    protected void setVehicleSize(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public abstract boolean canFitSlot(ParkingSlot slot);
}

class Car extends Vehicle {
    public Car() {
        setVehicleSize(1);
    }

    @Override
    public boolean canFitSlot(ParkingSlot slot) {
        return getVehicleSize() <= slot.getSlotSize();
    }
}

class Bus extends Vehicle {

    public Bus() {
        setVehicleSize(2);
    }

    @Override
    public boolean canFitSlot(ParkingSlot slot) {
        return getVehicleSize() <= slot.getSlotSize();
    }
}

class ParkingSlot {
    private String slotId;
    private int slotSize;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, int slotSize) {
        this.slotId = slotId;
        this.slotSize = slotSize;
    }

    public boolean isEmpty() {
        return vehicle == null;
    }

    public boolean isFit(Vehicle vehicle) {
        return isEmpty() && vehicle.canFitSlot(this);
    }

    public boolean park(Vehicle vehicle) {
        if (!isFit(vehicle)) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    public void checkOut() {
        vehicle = null;
    }

    public int getSlotSize() {
        return slotSize;
    }

}

class ParkingLot {
    private int availableSlots = 0;
    private ParkingSlot[] slots;

    private Map<Vehicle, ParkingSlot> map = new HashMap<>();

    private int slotsCounter = 0;
    public ParkingLot(int capacity) {
        slots = new ParkingSlot[capacity];
        // half car, half bus
        for (int i = 0; i < capacity / 2; i++) {
            slots[i] = new ParkingSlot("Bus " + i, 2);
            slotsCounter++;
        }
        for (int i = slotsCounter; i < capacity; i++) {
            slots[i] = new ParkingSlot("Car " + i, 1);
            slotsCounter++;
        }
        availableSlots = slotsCounter;
        System.out.println("Parking Lot initialized with " + availableSlots + " slots");
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSlots == 0) {
            return false;
        }
        int availableSlot = FindAvailableSlot(vehicle);
        boolean parkStatus = false;
        if (availableSlot != -1) {
            availableSlots--;
            parkStatus = slots[availableSlot].park(vehicle);
            map.put(vehicle, slots[availableSlot]);
        }
        return parkStatus;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        if (map.containsKey(vehicle)) {
            map.get(vehicle).checkOut();
            map.remove(vehicle);
            availableSlots++;
            return true;
        }
        return false;
    }

    public int FindAvailableSlot(Vehicle vehicle) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].isFit(vehicle)) {
                return i;
            }
        }
        return -1;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(4);
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle bus3 = new Bus();
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Bus 1 parked? " + parkingLot.parkVehicle(bus1));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Bus 2 parked? " + parkingLot.parkVehicle(bus2));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Bus 3 parked? " + parkingLot.parkVehicle(bus3));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Car 1 parked? " + parkingLot.parkVehicle(car1));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Car 2 parked? " + parkingLot.parkVehicle(car2));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");

        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("Car 3 parked? " + parkingLot.parkVehicle(car3));
        System.out.println("Current available slots: " + parkingLot.getAvailableSlots());
        System.out.println("===================");
    }
}