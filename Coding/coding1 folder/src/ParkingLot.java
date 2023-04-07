import java.util.Date;
import java.util.List;

public class ParkingLot {
    private String name;
    private boolean available;
    private List<Level> levels;

    public void enter(Vehicle vehicle){
        if(available && getAvailableCount() != 0){
            Level available =findLevelAvailable();
            ParkingSpot spot = available.availableSpot();
            spot.setAvailable(false);
            int availableCount = available.getAvailableCount()-1;
            available.updateAvailableCount(availableCount);
        }
    }
    public boolean isAvailable(){
        return available;
    }

    public Level findLevelAvailable(){
        for(int i = 0; i < levels.size();i++){
            if(levels.get(i).getAvailableCount() != 0){
                return levels.get(i);
            }
        }
        return null;
    }
    public int getAvailableCount(){
        int total = 0;
        for(Level level :levels) {
            total += level.getAvailableCount();
        }
        return total;
    }
    public Ticket exit(Vehicle vehicle){
        //didn't implement
       return null;
    }
    public float caclulate(Ticket ticket){
        float enterTime = ticket.getEnterTime().getTime();
        float exitTime = ticket.getExitTime().getTime();
        return (enterTime-exitTime)*15;
    }
}
