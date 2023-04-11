package pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("Joye"));
        subject.attach(new WeiXinUser("Chandler"));
        subject.attach(new WeiXinUser("Ross"));

        subject.notify("专栏更新了！");
    }
}
