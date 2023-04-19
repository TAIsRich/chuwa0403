import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2);

        Vehicle car1 = new Vehicle("ABC123");
        Vehicle car2 = new Vehicle("DEF456");
        Vehicle car3 = new Vehicle("GHI789");

        lot.parkVehicle(car1);
        lot.parkVehicle(car2);
        lot.parkVehicle(car3);
        ArrayList<Vehicle> parkedVehicles = lot.getParkedVehicles();
        System.out.println("List of parked vehicles:");
        for (Vehicle vehicle : parkedVehicles) {
            System.out.println(vehicle.getLicensePlate());
        }

        lot.removeVehicle(car2); // remove car "DEF456"
        System.out.println("Remove car \"DEF456\"");

        ArrayList<Vehicle> newParkedVehicles = lot.getParkedVehicles();
        System.out.println("List of parked vehicles:");
        for (Vehicle vehicle : newParkedVehicles) {
            System.out.println(vehicle.getLicensePlate());
        }
    }
}