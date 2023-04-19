package CreaditCardNotification;

public class User implements Observer {
    private String firstName;
    private String email;
    private String phone;
    private String notificationPreference;

    public User(String firstName, String email, String phone, String notificationPreference) {
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.notificationPreference = notificationPreference;
    }

    @Override
    public void update(Notification notification) {
        if (notification.getType().equals(notificationPreference)) {
            switch (notificationPreference) {
                case "email":
                    sendEmail(notification);
                    break;
                case "sms":
                    sendSms(notification);
                    break;
                case "whatsapp":
                    sendWhatsapp(notification);
                    break;
                default:
                    System.out.println("Invalid notification preference: " + notificationPreference);
                    break;
            }
        }
    }

    private void sendEmail(Notification notification) {
        // code to send email
        System.out.println("Sending email to " + firstName + " (" + email + ")");
    }

    private void sendSms(Notification notification) {
        // code to send SMS
        System.out.println("Sending SMS to " + firstName + " (" + phone + ")");
    }

    private void sendWhatsapp(Notification notification) {
        // code to send WhatsApp message
        System.out.println("Sending WhatsApp message to " + firstName + " (" + phone + ")");
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }

    public String getFirstName() {
        return firstName;
    }
}