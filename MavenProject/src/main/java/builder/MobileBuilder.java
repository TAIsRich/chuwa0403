package builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("tanxianweichejia");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("zhenpichezuo");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
