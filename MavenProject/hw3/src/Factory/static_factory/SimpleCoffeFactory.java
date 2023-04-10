package Factory.simple_factory;

public class SimpleCoffeFactory {
    public Coffee CreateCoffee(String type){
        Coffee coffee = null;
        if("american".equals(type)){
            coffee = new AmericanCoffee();
        }else if("latte".equals(type)){
            coffee = new LatteCoffee();
        }else{
            throw new RuntimeException("对不起，你点的咖啡没有");
        }
        return coffee;
    }


}
