package pattern.factory.abstract_factory;

import pattern.factory.abstract_factory.Dessert;

public interface FoodFactory {

    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜品的功能
    Dessert createDessert();

}
