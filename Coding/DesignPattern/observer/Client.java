package Coding.DesignPattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WechatUser("Rat"));
        subject.attach(new WechatUser("Dog"));
        subject.attach(new WechatUser("Cat"));

        subject.notify("update");
    }
}
