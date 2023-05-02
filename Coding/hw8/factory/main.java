package Coding.hw8.factory;

public class main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.createVehicle("car");
        Vehicle bus = factory.createVehicle("bus");

        car.start();
        car.stop();
        bus.start();
        bus.stop();
    }
}
