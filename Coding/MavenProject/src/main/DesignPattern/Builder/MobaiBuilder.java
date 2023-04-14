package DesignPattern.Builder;

public class MobaiBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("carbon");
    }

    @Override
    public void buildSeat() {
        bike.setFrame("leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
