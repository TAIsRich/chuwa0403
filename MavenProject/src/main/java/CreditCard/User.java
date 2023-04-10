package CreditCard;

public class User implements Observer {
    private String name;

    public String getPreference() {
        return preference;
    }

    private String preference;

    public User(String name, String preference) {
        this.name = name;
        this.preference = preference;
    }

    @Override
    public void update(String message, NotificationModule notification) {
        notification.sendNotification(name, message);

    }

}
