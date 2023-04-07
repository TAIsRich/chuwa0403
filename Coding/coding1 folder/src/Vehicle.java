public abstract class Vehicle {

    protected String brand;
    protected String plateNo;
    protected final VehicleType type;

    public Vehicle(VehicleType type) {
        this.type = type;
    }
}
