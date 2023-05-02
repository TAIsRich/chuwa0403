package com.richard.simplefactory;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public class CoffeeStore {

    private final SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();

    public Coffee orderCoffee(String type) {

        Coffee c = simpleCoffeeFactory.createCoffee(type);

        c.addMilk();
        c.addSugar();

        return c;
    }
}
