package design;

public abstract class User implements Observer {

    private String name;
    private String account;

    public abstract void update(String message);

    public String getName() {
        return this.name;
    }

    public String getAccount() {
        return this.account;
    }

    public abstract String getMethod();
}
