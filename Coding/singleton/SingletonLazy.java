package Coding.singleton;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null)
                    instance = new SingletonLazy();
            }
        }

        return instance;
    }
}
