package CreditCard;

public class EmailNotificationModule implements NotificationModule{
    @Override
    public void sendNotification(String userName, String message) {
        System.out.println("Sending to " + userName + " via email: " + message);
    }
}
