package pattern.observer;

public class Client {

    public static void main(String[] args) {

        // 1. 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 2. 订阅公众号
        subject.attach(new WeiXinUser("张三"));
        subject.attach(new WeiXinUser("李四"));
        subject.attach(new WeiXinUser("王五"));

        // 3. 公众号更新，发出消息给订阅者（观察者对象）
        subject.notify("您的订阅更新了");

    }
}
