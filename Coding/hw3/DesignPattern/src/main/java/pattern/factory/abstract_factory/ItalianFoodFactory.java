package pattern.factory.abstract_factory;

// 意大利工厂，生产拿铁 + 提拉米苏

public class ItalianFoodFactory implements FoodFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
