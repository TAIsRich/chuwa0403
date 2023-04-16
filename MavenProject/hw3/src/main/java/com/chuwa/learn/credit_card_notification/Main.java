package com.chuwa.learn.credit_card_notification;

public class Main {
    public static void main(String[] args) {
        Subject creditCardSubject = new CreditCardSubject();
        Observer user1 = new User("Tom", NotificationPreference.SMS);
        Observer user2 = new User("Lily", NotificationPreference.EMAIL);
        Observer user3 = new User("Jerry", NotificationPreference.WHATSAPP);

        creditCardSubject.attach(user1);
        creditCardSubject.attach(user2);
        creditCardSubject.attach(user3);

        creditCardSubject.notifyAll("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
