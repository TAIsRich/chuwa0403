import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int capacity, size;
    // Hold all the parking spots.
    private ParkingSpot[] arr;
    // If a vehicle is parked in the parking spot, record this relationship in the map.
    private Map<Vehicle, ParkingSpot> map;

    public ParkingLot(int capacity) {

        this.capacity = capacity;
        this.arr = new ParkingSpot[capacity];
        this.map = new HashMap<>();
        this.size = 0;

        for (int i = 0; i < capacity; i++) arr[i] = new ParkingSpot(i);

    }

    // If park successfully return true, otherwise false
    public boolean park(Vehicle v, int idx) {

        // If the parking lot i full
        // or the car is too big
        // or the spot is occupied, return false.
        if (size > capacity || !v.isFit(arr[idx]) || arr[idx].isOccupied()) {
            System.out.println("Car " + v.getId() + " parks failed.");
            return false;
        }

        size++;
        map.put(v, arr[idx]);
        arr[idx].setOccupied(true);

        System.out.println("Car " + v.getId() + " parks into " + arr[idx].getId());
        return true;

    }

    // Remove car v from the parking lot
    public void remove(Vehicle v) {

        if (!map.containsKey(v)) {
            System.out.println("Car " + v.getId() + " is not parked in this parking lot.");
            return;
        }

        map.get(v).setOccupied(false);
        size--;
        map.remove(v);

        System.out.println("Car " + v.getId() + " leaves this parking lot.");

    }

    // Find which spot is v in, if v doesn't exist return -1
    public int findCar(Vehicle v) {

        if (!map.containsKey(v)) {
            System.out.println("Can't find car + " + v.getId() + ".");
            return -1;
        }

        int ret = map.get(v).getId();
        System.out.println("Car " + v.getId() + " parks at " + ret + " parking spot.");
        return ret;

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingSpot[] getArr() {
        return arr;
    }

    public void setArr(ParkingSpot[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }
}
