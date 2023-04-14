package DesignPattern.Singleton;

public class Eager1 {
    private Eager1() {}
    private static Eager1 instance = new Eager1();

    public static Eager1 getInstance() {
        return instance;
    }
}
