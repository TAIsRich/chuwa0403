package Coding.hw8.factory;

public class VehicleFactory {
    public Vehicle createVehicle(String input) {
        if (input.equalsIgnoreCase("car")) {
            return new Car();
        } else if (input.equalsIgnoreCase("bus")) {
            return new Bus();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + input);
        }
    }
}
