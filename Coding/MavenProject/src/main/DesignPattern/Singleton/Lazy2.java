package DesignPattern.Singleton;

public class Lazy2 {
    private Lazy2() {}

    //volatile防止指令重排序。
    private volatile static Lazy2 instance;

    public static Lazy2 getInstance() {
        if (instance == null) {
            synchronized (Lazy2.class) {
                if (instance == null) {
                    instance = new Lazy2();
                }
            }
        }

        return instance;
    }
}
