package credit_card;

import static credit_card.NotificationType.EMAIL;

public class User {
    private String name;
    private String emailAddress;
    private NotificationType preference = EMAIL;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public NotificationType getPreference() {
        return preference;
    }

    public void setPreference(NotificationType preference) {
        this.preference = preference;
    }
}
