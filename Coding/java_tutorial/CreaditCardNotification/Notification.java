package CreaditCardNotification;

public class Notification {
    private String type;
    private String content;

    public Notification(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
