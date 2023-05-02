package SimpleFactory;

public class Client {
    public static void main(String[] args) {
        cakeShop shop = new cakeShop();
        Cake cake = shop.orderCake("milkCake");
        Cake cake1 = shop.orderCake("cheeseCake");
       // Cake cake2 = shop.orderCake("chocolateCake");
        System.out.println(cake.getName());
        System.out.println(cake1.getName());
        //System.out.println(cake2.getName());

    }
}
