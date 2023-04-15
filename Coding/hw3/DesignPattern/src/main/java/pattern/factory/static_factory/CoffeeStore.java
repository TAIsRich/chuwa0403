package pattern.factory.static_factory;

public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        // 1. 直接调用静态的创建咖啡对象
        Coffee coffee = StaticCoffeeFactory.createCoffee(type);

        // 2. 加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
