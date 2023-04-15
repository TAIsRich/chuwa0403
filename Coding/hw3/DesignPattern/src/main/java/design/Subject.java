package design;

// 抽象主题角色类

public interface Subject {

    // 添加订阅者（添加观察者对象）
    void attach(User user);

    // 删除订阅者
    void detach(User user);

    // 通知观察者更新消息
    void notify(String message);

}
