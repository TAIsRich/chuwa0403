package pattern.factory.abstract_factory;

public class Client {

    public static void main(String[] args) {

        // 创建意大利风味工厂对象
        ItalianFoodFactory factory = new ItalianFoodFactory();
        // 创建美式风味对象
        // AmericanFoodFactory factory = new AmericanFoodFactory();

        // 获取拿铁和提拉米苏
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
