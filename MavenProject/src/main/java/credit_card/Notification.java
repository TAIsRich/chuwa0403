package credit_card;

public abstract class Notification {
    public NotificationType getMessageType() {
        return notificationType;
    }

    public void setMessageType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    private NotificationType notificationType;

    public Notification(NotificationType notificationType) {
        this.notificationType = notificationType;
    }


}
