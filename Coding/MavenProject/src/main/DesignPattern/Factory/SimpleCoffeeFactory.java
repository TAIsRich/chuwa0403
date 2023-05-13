package DesignPattern.Factory;

public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        Coffee coffee;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new IllegalArgumentException("wrong type");
        }
        return coffee;
    }
}
