package CreditCard;

public interface Notification {
//    String getType();
    void sendNotification(User user, String message);
}

class EmailNotification implements Notification {

    public void sendNotification(User user, String message) {
        // Send email notification to user
    }
}

class SMSNotification implements Notification {

    public void sendNotification(User user, String message) {
        // Send SMS notification to user
    }
}

class WhatsappNotification implements Notification {

    public void sendNotification(User user, String message) {
        // Send Whatsapp notification to user
    }
}