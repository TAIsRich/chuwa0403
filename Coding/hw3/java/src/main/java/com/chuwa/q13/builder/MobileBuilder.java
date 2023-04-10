package com.chuwa.q13.builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("silver");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("real car");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
