package design;

// 具体的观察者角色类

public class WhatsAPPUser extends User {

    private String name;
    private String account;

    public WhatsAPPUser(String name, String account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public String getMethod() {
        return "WhatsAPP";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " with WhatsAPP account" + account + ": " + message);
    }
}
