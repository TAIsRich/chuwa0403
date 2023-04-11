package pattern.singleton.eager;

public class EagerSingleton1 {
    private EagerSingleton1() {}

    private static EagerSingleton1 eagerSingleton = new EagerSingleton1();

    public static EagerSingleton1 getInstance() {
        return eagerSingleton;
    }
}
