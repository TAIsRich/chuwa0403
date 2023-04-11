package design;

public class Client {

    public static void main(String[] args) {

        // 1. 创建对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 2. 订阅
        subject.attach(new EmailUser("Jack", "jack@gmail.com"));
        subject.attach(new EmailUser("Rose", "rose@icloud.com"));
        subject.attach(new WhatsAPPUser("Peter", "peter_zz"));
        subject.attach(new SMSUser("Richard", "9887152471"));

        System.out.println("------------------------------------------------------------------");

        // 3. 公众号更新，发出消息给订阅者（观察者对象）
        subject.notify("40% off when you buy Popeyes between 06/13 - 06/19");

    }
}
