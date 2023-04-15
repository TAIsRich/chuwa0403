package DesignPattern.PS;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WexinUser("Hello"));
        subject.notify("Hello");
    }
}
