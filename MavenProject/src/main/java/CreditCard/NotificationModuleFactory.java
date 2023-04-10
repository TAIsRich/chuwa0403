package CreditCard;

public class NotificationModuleFactory {
    public static NotificationModule createNotificationModule(String preference) {
        switch(preference) {
            case "email":
                return new EmailNotificationModule();
            case "sms":
                return new SMSNotificationModule();
            case "whatsapp":
                return new WhatsAppNotificationModule();
            default:
                throw new IllegalArgumentException("Invalid notification preference: " + preference);
        }
    }
}
