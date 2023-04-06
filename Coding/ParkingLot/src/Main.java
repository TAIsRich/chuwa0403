public class Main {

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(20);

        Vehicle[] cars = new Vehicle[30];

        for (int i = 0; i < 30; i++) cars[i] = new Vehicle(i);

        // Park car 0~19 to the parking lot;
        for (int i = 0; i < 20; i++) {
            lot.park(cars[i], i);
        }

        // Park another car, and this will fail due to the lot is full.
        lot.park(cars[20], 0);
        // Park a car that is already parked in this lot.
        lot.park(cars[0], 0);

        // Remove car 0 from 0 parking spot
        lot.remove(cars[0]);

        // Create a car that can't fit into a spot, which will cause park failure.
        Vehicle bigCar = new Vehicle(31, 100000, 100000, 100000, 10000);
        lot.park(bigCar, 0);

    }
}
