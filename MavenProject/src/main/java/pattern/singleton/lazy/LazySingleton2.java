package pattern.singleton.lazy;

public class LazySingleton2 {

    private LazySingleton2() {}

    private static class SingletonHolder {
        private static final LazySingleton2 INSTANCE = new LazySingleton2();
    }

    public static LazySingleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
