package pattern.factory.static_factory;

public class StaticCoffeeFactory {

    public static Coffee createCoffee(String type) {

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
