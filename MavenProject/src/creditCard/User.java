package MavenProject.src.creditCard;

public class User implements Observer{
    private String name;
    private String preference;

    public User(String name, String preference) {
        this.name = name;
        this.preference = preference;
    }

    @Override
    public void update(String message, Notification notification) {
        notification.send(this.name, message);
    }

    @Override
    public String getPreference() {
        return preference;
    }
}
