package pattern.singleton.lazy.demo1;

/*
 * @Description Lazy - thread not safe
 * @Author Richard
 */

public class Singleton {

    // 1. 私有构造方法
    private Singleton() {}

    // 2. 声明Singleton类型变量
    private static Singleton instance; // null

    // 3. 对外提供访问方式
    public static Singleton getInstance() {

        // 4. 判断如果为null，说明没有创建。如果不为null，直接返回。
        if (instance == null) {
            // 假设出现多线程情况：
            // 线程1获得CPU执行权
            // 线程1等待，线程2获得CPU执行权，也会进入判断里面
            // 这样就会创建更多的单例了

            instance = new Singleton();
        }
        return instance;

    }
}
