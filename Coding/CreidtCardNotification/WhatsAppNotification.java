package Coding.CreidtCardNotification;


class WhatsAppNotification implements Notification {
    public void sendNotification(User user, String message) {
        
        System.out.println("Sent WhatsApp notification to " + user.getPhone() + " with message: " + message);
    }
}