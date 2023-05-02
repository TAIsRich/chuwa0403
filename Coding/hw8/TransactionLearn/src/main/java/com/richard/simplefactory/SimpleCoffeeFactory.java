package com.richard.simplefactory;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {

        Coffee c = null;

        if (type.equalsIgnoreCase("american")) {
            c = new AmericanCoffee();
        } else if (type.equalsIgnoreCase("latte")) {
            c = new LatteCoffee();
        } else {
            throw new RuntimeException("Sorry, no such coffee");
        }

        return c;
    }
}
