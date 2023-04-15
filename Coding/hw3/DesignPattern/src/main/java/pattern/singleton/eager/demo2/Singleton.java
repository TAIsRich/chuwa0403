package pattern.singleton.eager.demo2;

/*
 * @Description Eager initialization - static code block
 * @Author Richard
 */

public class Singleton {

    // 1. 私有构造方法
    private Singleton() {}

    // 2. 声明Singleton类型的变量
    private static Singleton instance; // null

    // 3. 在代码块中创建对象
    static {
        instance = new Singleton();
    }

    // 4. 对外提供获取该类的方法
    public static Singleton getInstance() {
        return instance;
    }
}
