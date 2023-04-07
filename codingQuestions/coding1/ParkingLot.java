import java.util.*;

public class ParkingLot {
    private int count;
    private int size;
    private Slot[] slots;

    public ParkingLot(int size_) {
        this.size = size_;
        this.count = 0;
        this.slots = new Slot[this.size];

        for (int i = 0; i < this.size; i++) {
            slots[i] = new Slot(i);
        }
    }

    public void parkOneCar(Car car) {
        if (checkAvailableSlots() == false) {
            System.out.println("No available position");
            return;
        }
        Slot availSlot = findAvailableSlot();
        this.count += 1;
        parkCarInSlot(car, availSlot);
        System.out.println("Parked");
    }

    public void unParkOneCar(Car car) {
        for (int i = 0; i < this.size; i++) {
            if (slots[i].getCar().getLicense().equals(car.getLicense())) {
                unParkCarInSlot(slots[i]);
                this.count -= 1;
                System.out.println("Successfully unpark the car " + car.getLicense());
                return;
            }
        }
        System.out.println("No this car: " + car.getLicense());
    }

    public void unParkCarInSlot(Slot availSlot) {
        availSlot.unOccupiedACar();
        availSlot.setEndTime();
    }

    public void parkCarInSlot(Car car, Slot availSlot) {
        availSlot.occupiedByACar(car);
        availSlot.setStartTime();
    }

    public Slot findAvailableSlot() {
        for (int i = 0; i < this.size; i++) {
            if (slots[i].isOccupied() == false) {
                return slots[i];
            }
        }
        return null; // should never get here
    }

    public boolean checkAvailableSlots() {
        return this.count == this.size;
    }

    private static class Slot {
        private Date startTime;
        private Date endTime;
        private int id;

        private Car car = null;

        public Slot(int id_) {
            this.id = id_;
        }

        public Car getCar() {
            return this.car;
        }

        public void occupiedByACar(Car car) {
            this.car = car;
        }

        public void unOccupiedACar() {
            this.car = null;
        }

        public Date getStartTime() {
            return this.startTime;
        }

        public void setStartTime() {
            this.startTime = new Date(System.currentTimeMillis());
        }

        public Date getEndTime() {
            return this.endTime;
        }

        public void setEndTime() {
            this.endTime = new Date(System.currentTimeMillis());
        }

        public int getId() {
            return this.id;
        }

        public boolean isOccupied() {
            return car != null;
        }
    }

}

class Car {
    private String license;

    public Car(String license_) {
        this.license = license_;
    }

    public String getLicense() {
        return this.license;
    }
}
