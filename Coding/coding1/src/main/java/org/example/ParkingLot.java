package org.example;

import java.util.List;

public class ParkingLot {
    private String name;
    private boolean available;
    private List<Level> levels;

    public void enter(Vehicle vehicle){

    }

    public boolean isAvailable() {
        return available;
    }

    public Level findLevelAvailable(){
        return null;
    }

    public int getAvailable(){
        return 1;
    }

    public boolean canVehicleFit(Vehicle vehicle){
        return true;
    }

    public Ticket exit(Vehicle vehicle){
        return null;
    }

    public float calculate(Ticket ticket){
        return 0;
    }
}
