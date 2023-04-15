package CreditCard;

public class CreditCardNotificationTest {
    public static void main(String[] args) {
        CreditCardNotification test = new CreditCardNotification();
        Observer user1 = new User("a", "email");
        Observer user2 = new User("b", "sms");
        Observer user3 = new User("c", "whatsapp");

        test.attach(user1);
        test.attach(user2);
        test.attach(user3);

        test.notifyAll("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
