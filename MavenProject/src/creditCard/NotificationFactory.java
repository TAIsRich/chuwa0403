package MavenProject.src.creditCard;

public class NotificationFactory {
    public Notification createNotification(String preference) throws Exception {
        Notification notification;
        if (preference == "email")
            notification = new EmailNotification();
        else if (preference == "sms")
            notification = new SmsNotification();
        else if (preference == "whatsapp")
            notification = new WhatsappNotification();
        else
            throw new Exception("No such method");

        return notification;
    }
}
