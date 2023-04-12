public class SimpleFactory {
    
}

// abstract product
// concrete prodcut
// abstract factory: provide creating product interface
// concreate factory/creator

class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("latte");

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

class CoffeeFactory {

    // change this method to static -> avoid creating object
    public static Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据不同类型创建不同的coffee子类对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("no exist");
        }

        return coffee;
    }
}

class CoffeeStore {

    // coffe store use coffe factory
    // do not need to use coffee product directly
    public Coffee orderCoffee(String type) {

        Coffee coffee  = SimpleCoffeeFactory.createCoffee(type);
        // SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        // Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
