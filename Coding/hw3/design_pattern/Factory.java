public class Factory {
    
}
// abstract product
// concrete prodcut
// abstract factory: provide creating product interface
// concreate factory/creator

// code might become really complicated
class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        // change this factory to change the type of coffe
        // if want to add a coffe -> add a coffe and a coffeFactory
        // no need to change the origin code
        CoffeeFactory facotry = new AmericanCoffeeFactory();
        store.setFactory(facotry);
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}


abstract class Coffee{
    public abstract String getName();

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addMilk() {
        System.out.println("add Milk");
    }
}

class LatteCoffee extends Coffee {

    @Override
    public String getName() {
        return "Latte Coffee";
    }
}

class AmericanCoffee extends Coffee {

    @Override
    public String getName() {
        return "American Coffee";
    }
}

interface CoffeeFactory {
    Coffee creatCoffee();
}

class AmericanCoffeeFactory implements CoffeeFactory {
    Coffee createCoffee() {
        return new AmericanCoffee();
    }
}

class LatteCoffeeFactory implements CoffeeFactory {
    Coffee createCoffee() {
        return new LatteCoffee();
    }
}


class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }
    public Coffee orderCoffee() {

        Coffee coffee  = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
