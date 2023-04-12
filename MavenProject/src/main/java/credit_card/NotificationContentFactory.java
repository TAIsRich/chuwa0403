package credit_card;

public class NotificationContentFactory implements ContentFactory{

    @Override
    public Content generateContent(User user) {
        return new NotificationContent(user.getName() + "you have successfully registered to add and here is your , please use this for \n" +
                "future references.");
    }
}
