package DesignPattern.Singleton;

public class Lazy1 {
    private Lazy1() {}

    private static Lazy1 instance;

    public static Lazy1 getInstance() {
        if (instance == null) {
            instance = new Lazy1();
        }
        return instance;
    }
}
