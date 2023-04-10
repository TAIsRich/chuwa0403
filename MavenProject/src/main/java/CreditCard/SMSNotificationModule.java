package CreditCard;

public class SMSNotificationModule implements NotificationModule{
    @Override
    public void sendNotification(String userName, String message) {
        System.out.println("Sending to " + userName + " via SMS: " + message);
    }
}
