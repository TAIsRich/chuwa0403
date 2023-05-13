package CreditCard;

public class User {
    private String name;
    private String email;
    private String phone;
    private String whatsapp;

    // User's preference type of notification
    private NotificationType notificationPreference;


    public User(String name, String email, String phone, String whatsapp, NotificationType notificationPreference) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.whatsapp = whatsapp;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public NotificationType getNotificationPreference() {
        return notificationPreference;
    }
}
