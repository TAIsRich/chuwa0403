package pattern.factory.simple_factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        // 1. 创建简单工厂
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        // 2. 调用生产咖啡的方法
        Coffee coffee = factory.createCoffee(type);

        // 3. 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
