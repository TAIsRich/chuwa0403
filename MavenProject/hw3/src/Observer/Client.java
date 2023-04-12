package Observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WeixinUser("孙悟空"));
        subject.attach(new WeixinUser("猪悟能"));
        subject.attach(new WeixinUser("沙悟净"));

        subject.notify("更新啦！");
    }
}
