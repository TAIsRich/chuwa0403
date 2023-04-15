package MavenProject.src.pattern.simple_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addMilk();

        return coffee;
    }
}
