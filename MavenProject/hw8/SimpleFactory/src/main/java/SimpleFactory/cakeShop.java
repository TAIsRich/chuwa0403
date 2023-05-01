package SimpleFactory;

public class cakeShop {
    public Cake orderCake(String type){
        cakeFactory factory = new cakeFactory();
        Cake cake = factory.makeCake(type);
        return cake;

    }
}
