package CreditCard;

public interface Observer {
        void update(String message, NotificationModule notification);
        String getPreference();
}
