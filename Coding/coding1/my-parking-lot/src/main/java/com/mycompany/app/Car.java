package com.mycompany.app;
import java.util.*;

public class Car
{
    private String licensePlate;
    private String color;

    public Car(String licensePlate, String color) {
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }
}