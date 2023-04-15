import java.util.ArrayList;

public class ParkingLot {
    private String name;
    private String location;
    private int slocCount;

    private SLOT[] slots;
    private ArrayList<Customer> customers;

    ParkingLot(String name, String location, int slocCount){
        this.name= name;
        this.location = location;
        this.slocCount = slocCount;

        slots = new SLOT[slocCount];
        customers = new ArrayList<>();
    }
}

class SLOT{
    int num;
    
}
