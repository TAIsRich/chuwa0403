package builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("lvhejinchejia");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("xiangjiaochezuo");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
