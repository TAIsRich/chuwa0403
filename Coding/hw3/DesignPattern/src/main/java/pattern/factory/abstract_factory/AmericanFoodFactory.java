package pattern.factory.abstract_factory;

// 美式风味的工厂，生产美式咖啡 + 抹茶慕斯

public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
