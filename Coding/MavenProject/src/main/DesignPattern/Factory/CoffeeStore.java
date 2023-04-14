package DesignPattern.Factory;

public class CoffeeStore {
    private final AbstractCoffeeFactory coffeeFactory;

    public CoffeeStore(AbstractCoffeeFactory factory) {
        this.coffeeFactory = factory;
    }

    public Coffee getCoffee() {
        return coffeeFactory.createCoffee();
    }
}