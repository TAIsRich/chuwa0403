package Coding.CreidtCardNotification;

class SMSNotification implements Notification {
    public void sendNotification(User user, String message) {
        // Code to send SMS notification
        System.out.println("Sent SMS notification to " + user.getPhone() + " with message: " + message);
    }
}