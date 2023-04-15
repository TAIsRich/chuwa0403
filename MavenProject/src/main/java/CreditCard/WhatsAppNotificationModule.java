package CreditCard;

public class WhatsAppNotificationModule implements NotificationModule{
    @Override
    public void sendNotification(String userName, String message) {
        System.out.println("Sending to " + userName + " via Whatsapp: " + message);
    }
}
