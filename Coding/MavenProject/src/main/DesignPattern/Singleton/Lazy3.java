package DesignPattern.Singleton;

public class Lazy3 {
    private Lazy3() {}

    private static class SingletonHolder {
        private static final Lazy3 INSTANCE = new Lazy3();
    }

    public Lazy3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
