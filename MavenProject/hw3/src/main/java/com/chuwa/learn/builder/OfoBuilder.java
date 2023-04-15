package com.chuwa.learn.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("plastic");
    }

    @Override
    public void buildSeat() {
        bike.setFrame("steel");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
