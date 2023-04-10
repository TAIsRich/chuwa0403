package pattern.factory.simple_factory;

public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {

        Coffee coffee = null;

        if (type.equals("american")) {
            coffee = new AmericanCoffee();
        } else if (type.equals("latte")) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("This type of coffee isn't available.");
        }

        return coffee;
    }
}
