package MavenProject.src.pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        subscriptionSubject.attach(new WeixinUser("xxx"));
        subscriptionSubject.attach(new WeixinUser("yyy"));
        subscriptionSubject.attach(new WeixinUser("zzz"));

        subscriptionSubject.notify("new message");
    }
}
