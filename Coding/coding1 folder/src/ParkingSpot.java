public class ParkingSpot {
    private final ParkingSpotType type;
    private boolean available;
    private Vehicle vehicle;
    private int spotNo;
    private Level level;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }
    public boolean isAvailable(){
        return available;
    }
    public boolean canVehicleFit(Vehicle vehicle){
        if(vehicle.type.equals(this.type)){
            return true;
        }
        return false;
    }
    public void takeSpot(Vehicle vehicle){
        if(isAvailable()) {
            available = false;
        }
    }
    public void leaveSpot(Vehicle vehicle){
            available = true;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
