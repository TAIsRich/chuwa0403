package Coding.DesignPattern.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Aluminum frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Rubber seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}