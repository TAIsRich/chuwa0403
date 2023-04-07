import java.util.List;

public class Level {
    private List<ParkingSpot> spotList;
    private int availableCount;
    private boolean available;

    public Level(int availableCount) {
        this.availableCount = Constants.NUM_SPORTS;
    }
    public boolean isAvailable(){
        return available;
    }
    public ParkingSpot availableSpot() {
        if(getAvailableCount() != 0){
            for(ParkingSpot spot : spotList){
                if(spot.isAvailable()){
                    return spot;
                }
            }
        }
        return null;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void updateAvailableCount(int availableCount) {
       this.availableCount = availableCount;
    }
}
