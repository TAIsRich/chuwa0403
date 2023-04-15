package MavenProject.src.creditCard;

public interface Observer {
    void update(String message, Notification notification);

    String getPreference();
}
