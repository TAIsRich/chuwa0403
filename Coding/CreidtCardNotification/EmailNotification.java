package Coding.CreidtCardNotification;

class EmailNotification implements Notification {
    public void sendNotification(User user, String message) {
        System.out.println("Sent email notification to " + user.getEmail() + " with message: " + message);
    }
}
