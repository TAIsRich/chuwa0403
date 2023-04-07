package org.example;

import java.util.List;

import static org.example.Constants.NUM_SPOTS;

public class Level {
    private List<ParkingSpotType> spotList;
    private int availableCount;
    private boolean available;

    public Level(int availableCount){
        this.availableCount = NUM_SPOTS;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void updateAvailableCount() {
    }
}
