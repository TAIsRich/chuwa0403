package Builder.demo1;

public class MobikeBuilder extends Builder{

    @Override
    public void builderFrame() {
        bike.setFrame("碳纤维车架");

    }

    @Override
    public void builderSeat() {
        bike.setSeat("真皮车座");

    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
