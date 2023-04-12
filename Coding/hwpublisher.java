import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observer;

public class hwpublisher {
}
public interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
public class SubscriptionSubject implements Subject{
    private List<Observer> weixinUserlist = new ArrayList<Observer>();
    public attach(Observer observer){
        weixinUserlist.add(observer);
    }
    public detach(Observer observer){
        weixinUserlist.remove(observer);
    }
    public notify(String message){
        for (Observer observer : weixinUserlist){
            observer.update(message);
        }
    }
}
public class WeixinUser implements Observer{
    private String name;
    public WeixinUser(String message){
        this.name=name;
    }
    public void update(String message){
        System.out.print(name+"-"+message);
    }
}
public class client{
    public static void main(String[] args){
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeixinUser(name="abc"));
        subject.notify("ooo");
    }
}