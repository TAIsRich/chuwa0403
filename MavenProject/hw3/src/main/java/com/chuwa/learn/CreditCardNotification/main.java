package com.chuwa.learn.CreditCardNotification;

public class main {
    public static void main(String[] args) {
        Subject creditCardSubject = new CreditCardSubject();
        Observer user1 = new User("Alice", Preference.SMS);
        Observer user2 = new User("Alex", Preference.EMAIL);
        Observer user3 = new User("Jim", Preference.WHATSAPP);

        creditCardSubject.attach(user1);
        creditCardSubject.attach(user2);
        creditCardSubject.attach(user3);


        creditCardSubject.notifyAll("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
