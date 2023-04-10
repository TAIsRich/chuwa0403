package pattern.singleton.lazy.demo2;

/*
 * @Description Lazy - thread safe
 * @Author Richard
 */

public class Singleton {

    // 1. 私有构造方法
    private Singleton() {}

    // 2. 声明Singleton类型变量
    private static Singleton instance; // null

    // 3. 对外提供访问方式
    public static synchronized Singleton getInstance() {

        // 4. 判断如果为null，说明没有创建。如果不为null，直接返回。
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;

    }
}
