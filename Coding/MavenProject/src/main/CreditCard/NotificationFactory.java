package CreditCard;

public class NotificationFactory {
    public Notification createNotification(NotificationType notificationType) {
        if (notificationType.equals("email")) {
            return new EmailNotification();
        } else if (notificationType.equals("sms")) {
            return new SMSNotification();
        } else if (notificationType.equals("whatsapp")) {
            return new WhatsappNotification();
        }
        throw new IllegalArgumentException("Invalid notification type");
    }
}
