package com.chuwa.q13.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("silicon");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("steal");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
