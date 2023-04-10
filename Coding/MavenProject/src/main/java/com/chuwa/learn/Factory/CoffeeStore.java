package com.chuwa.learn.Factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type){

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
