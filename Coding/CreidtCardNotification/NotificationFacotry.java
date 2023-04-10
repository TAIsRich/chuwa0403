package Coding.CreidtCardNotification;

class NotificationFactory {
    public Notification createNotification(String preference) {
        switch (preference) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            default:
                throw new IllegalArgumentException("Invalid notification preference: " + preference);
        }
    }
}