package Factory.simple_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
       SimpleCoffeFactory factory = new SimpleCoffeFactory();
       Coffee coffee = factory.CreateCoffee(type);
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
