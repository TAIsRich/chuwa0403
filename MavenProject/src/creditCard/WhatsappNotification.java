package MavenProject.src.creditCard;

public class WhatsappNotification implements Notification{
    @Override
    public void send(String user, String message) {
        System.out.println("User: " + user + ", Message: " + message + ", Method: whatsapp");
    }
}
