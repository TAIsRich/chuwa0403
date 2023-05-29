import java.sql.Date;
import java.util.ArrayList;

public class Vehicle {
    private String num;
    private String type;
    private int size;
    private Date parkIn;
    private int time;

    private ArrayList<ParkingRecord> records;
    

    Vehicle(String n){
        num = n;
        records = new ArrayList<>();
    }

    Vehicle(String n, String type, int size){
        this(n);
        this.type = type;
        this.size = size;
    }

    public void addRecords(ParkingRecord r){
        records.add(r);
    }



    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getParkIn() {
        return parkIn;
    }

    public void setParkIn(Date parkIn) {
        this.parkIn = parkIn;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    
}