package Factory.factory_method;

public class AmericanCoffeeFactory implements CoffeeFactory {
    public Coffee createCoffee(){
        return new AmericanCoffee();
    }
}
