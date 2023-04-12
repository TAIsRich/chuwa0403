package hw3.design_credit_card;

public class EmailNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
