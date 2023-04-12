public class ParkingLot {
    private int capacity;
    private int availableSpaces;
    public String carMaker;
    public String carModel;
    public String plate;

    public String getCarMaker() {
        return carMaker;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getPlate() {
        return plate;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.availableSpaces = capacity;
    }

    public boolean parkCar() {
        if (availableSpaces == 0) {
            System.out.println("Sorry, parking lot is full.");
            return false;
        }
        availableSpaces--;
        System.out.println("Car parked successfully.");
        return true;
    }

    public boolean unparkCar() {
        if (availableSpaces == capacity) {
            System.out.println("Parking lot is already empty.");
            return false;
        }
        availableSpaces++;
        System.out.println("Car unparked successfully.");
        return true;
    }

    public void displayAvailableSpaces() {
        System.out.println("Available parking spaces: " + availableSpaces);
    }

    public static void main(String args[]) {
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.displayAvailableSpaces();
        parkingLot.parkCar();
        parkingLot.displayAvailableSpaces();
        parkingLot.unparkCar();
        parkingLot.displayAvailableSpaces();
        parkingLot.getCarMaker();
        parkingLot.getCarModel();
        parkingLot.getPlate();
    }
}

