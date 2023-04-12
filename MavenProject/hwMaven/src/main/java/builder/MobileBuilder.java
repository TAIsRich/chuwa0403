package builder;

public class MobileBuilder extends Builder{


    @Override
    public void buildFrame() {
        bike.setFrame("Carbon fiber frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather seat");

    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
