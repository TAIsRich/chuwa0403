package com.mycompany.app;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ParkingLot myParkingLot = new ParkingLot(50);
        Car car1 = new Car("ABCD","red");
        Car car2 = new Car("1234","blue");
        System.out.println(myParkingLot.parkCar(car1,1));
        System.out.println(myParkingLot.parkCar(car2,1));
        System.out.println(myParkingLot.parkCar(car2,2));
        System.out.println(myParkingLot.unparkCar(0));
        System.out.println(myParkingLot.unparkCar(1));
        System.out.println(myParkingLot.unparkCar(2));

    }
}
