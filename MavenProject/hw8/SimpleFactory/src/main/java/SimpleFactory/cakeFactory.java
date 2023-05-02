package SimpleFactory;

public class cakeFactory {
    public Cake makeCake(String type){
        Cake cake = null;
        if(type.equals("milkCake")){
            cake = new milkCake();
        }else if(type.equals("cheeseCake")){
            cake = new cheeseCake();
        }else{
            throw new RuntimeException("We don't have it");
        }
        return cake;
    }
}
