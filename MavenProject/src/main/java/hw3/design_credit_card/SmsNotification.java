package hw3.design_credit_card;

public class SmsNotification extends  Notification{
    @Override
    public void sendMessage() {
        System.out.println("SMS message");
    }
}
