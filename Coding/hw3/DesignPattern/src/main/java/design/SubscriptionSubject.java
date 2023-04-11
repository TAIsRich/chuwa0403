package design;

// 具体主题角色类

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {

    // 定义一个集合，用于存储多个观察者对象
    private List<User> userList = new ArrayList<>();

    @Override
    public void attach(User user) {
        userList.add(user);
        System.out.println("Hey " + user.getName() + ", you have successfully registered to" + user.getMethod() + " and here is your account: " + user.getAccount() + ", please use this for future references.");
    }

    @Override
    public void detach(User user) {
        userList.remove(user);
        System.out.println(user.getName() + " is unregistered.");
    }

    @Override
    public void notify(String message) {
        // 遍历集合
        for (Observer observer : userList) {
            // 调用观察者对象中的update方法
            observer.update(message);
        }
    }
}
