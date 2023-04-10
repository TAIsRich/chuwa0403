package pattern.factory.factory_method;

public class Client {

    public static void main(String[] args) {

        // 创建咖啡店
        CoffeeStore store = new CoffeeStore();

        // 创建工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        store.setFactory(factory);

        // 点咖啡
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}
