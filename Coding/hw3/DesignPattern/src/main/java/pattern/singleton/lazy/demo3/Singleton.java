package pattern.singleton.lazy.demo3;

/*
 * @Description Lazy - double lock check
 * @Author Richard
 */

public class Singleton {

    // 1. 私有构造方法
    private Singleton() {}

    // 2. 声明成员变量，并且添加volatile关键字，保证指令有序性
    private static volatile Singleton instance;

    // 3. 对外提供公共的访问方式
    public static Singleton getInstance() {

        // 4. 第一次判断，如果instance不为null，不需要抢占锁，直接返回
        if (instance == null) {

            synchronized (Singleton.class) {
                // 5. 第二次判断
                if (instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;

    }
}
