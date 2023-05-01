public class factory {
}
public abstract class Coffee{
    public abstract String getName();
    public void addsugar(){
        System.out.print("add sugar");
    }
    public void addmilk(){
        System.out.print("add milk");
    }
}
public class AmericanCoffee extends Coffee{
    public String getName(){
        return "American coffee";
    }
}
public class LatteCoffee extends Coffee{
    public String getName(){
        return "Latte coffee";
    }
}
public class CoffeeStore{
    public Coffee ordercoffee(String type){
        Coffee coffee =null;
        if ("american".equals(type)){
            coffee = new AmericanCoffee();
        }
        else if ("latte".equals(type)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("out of stock");
        }
        return coffee;
    }
}

public class Client{
    public static void main(String[] args){
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.ordercoffee(type="latte");
        System.out.print(coffee.getName());
    }

}
