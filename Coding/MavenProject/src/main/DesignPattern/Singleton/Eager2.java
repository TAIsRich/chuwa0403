package DesignPattern.Singleton;

public class Eager2 {
    private Eager2() {}

    private static Eager2 instance;

    static {
        instance = new Eager2();
    }

    public static Eager2 getInstance() {
        return instance;
    }
}
