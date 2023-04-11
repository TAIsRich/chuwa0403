package design;

// 具体的观察者角色类

public class EmailUser extends User {

    private String name;
    private String account;

    public EmailUser(String name, String email) {
        this.name = name;
        this.account = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMethod() {
        return "Email";
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " with email " + account + ": " + message);
    }
}
