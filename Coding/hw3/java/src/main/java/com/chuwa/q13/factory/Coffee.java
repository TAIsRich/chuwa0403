package com.chuwa.q13.factory;

public abstract class Coffee {
    public abstract String getName();

    public void addsugar() {
        System.out.println("sugar");
    }

    public void addmilk() {
        System.out.println("milk");
    }
}
