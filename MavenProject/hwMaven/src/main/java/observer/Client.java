package observer;

public class Client {
    public static void main(String[] args) {

        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("sunwukong"));
        subject.attach(new WeiXinUser("zhuwuneng"));
        subject.attach(new WeiXinUser("shawujing"));

        subject.notify("update!");
    }
}
