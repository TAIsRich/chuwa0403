package Coding.DesignPattern.factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("american");
        System.out.println(coffee.getName());

    }
}
