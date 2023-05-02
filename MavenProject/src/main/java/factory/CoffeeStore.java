package factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type){

        SimpleCoffeeFactory fac = new SimpleCoffeeFactory();
        Coffee coffee = fac.createCoffee(type);
        coffee.addMilk();
        coffee.addSugar();

        return coffee;

    }

}
