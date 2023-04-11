package pattern.singleton.lazy;

public class LazySingleton1 {
    private static volatile LazySingleton1 lazySingleton1; //多线程可能会出现空指针 volatile 保证有序性
    private LazySingleton1() {};

    public static LazySingleton1 getInstance() {
        if (lazySingleton1 == null) {
            synchronized (LazySingleton1.class) {
                if (lazySingleton1 == null) {
                    lazySingleton1 = new LazySingleton1();
                }
            }
        }
        return lazySingleton1;
    }
}
