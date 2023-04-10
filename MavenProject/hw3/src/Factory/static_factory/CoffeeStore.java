package Factory.static_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){

       Coffee coffee = SimpleCoffeFactory.CreateCoffee(type);
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
