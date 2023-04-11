package pattern.singleton.eager;

public class EagerSingleton2 {
    private EagerSingleton2() {}

    private static volatile EagerSingleton2 eagerSingleton2;

    static {
        eagerSingleton2 = new EagerSingleton2();
    }

    public static EagerSingleton2 getInstance() {
        return eagerSingleton2;
    }
}
