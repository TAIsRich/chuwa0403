package Factory.static_factory;


public class CoffeeStore {
    public Coffee orderCoffee(String type){
//       SimpleCoffeFactory factory = new SimpleCoffeFactory();
//       Coffee coffee = factory.createCoffee(type);
       Coffee coffee = SimpleCoffeFactory.createCoffee(type);
       coffee.addMilk();
       coffee.addSugar();
        return coffee;
    }
}
