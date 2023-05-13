package DesignPattern.Factory;

public interface AbstractCoffeeFactory {
    Coffee createCoffee();
    Dessert createDessert();
}

class AmericanFoodFactory implements AbstractCoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Mousse();
    }
}

class ItalyFoodFactory implements AbstractCoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}