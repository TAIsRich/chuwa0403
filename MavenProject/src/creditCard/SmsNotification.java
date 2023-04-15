package MavenProject.src.creditCard;

public class SmsNotification implements Notification{
    @Override
    public void send(String user, String message) {
        System.out.println("User: " + user + ", Message: " + message + ", Method: sms");
    }
}
