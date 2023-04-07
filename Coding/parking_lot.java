// code from internet
public enum VehicleSize { Motorcycle, Compact,Large }
public abstract class Vehicle
{
    protected ArrayList<ParkingSpot> parkingSpots =
            new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;
    public int getSpotsNeeded()
    {
        return spotsNeeded;
    }
    public VehicleSize getSize()
    {
        return size;
    }
    public void parkinSpot(ParkingSpot s)
    {
        parkingSpots.add(s);
    }
    public void clearSpots() { ... }
    public abstract boolean canFitinSpot(ParkingSpot spot);
}
public class Bus extends Vehicle
{
    public Bus()
    {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
    public boolean canFitinSpot(ParkingSpot spot)
    {... }
}
public class Car extends Vehicle
{
    public Car()
    {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }
    public boolean canFitinSpot(ParkingSpot spot)
    { ... }
}

public class Motorcycle extends Vehicle
{
    public Motorcycle()
    {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    public boolean canFitinSpot(ParkingSpot spot)
    { ... }
}
public class ParkingSpot
{
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;
    public ParkingSpot(Level lvl, int r, int n,
                       VehicleSize s)
    { ... }
    public boolean isAvailable()
    {
        return vehicle == null;
    }
    public boolean canFitVehicle(Vehicle vehicle) { ... }
    public boolean park(Vehicle v) {..}
    public int getRow()
    {
        return row;
    }
    public int getSpotNumber()
    {
        return spotNumber;
    }
    public void removeVehicle() { ... }
}