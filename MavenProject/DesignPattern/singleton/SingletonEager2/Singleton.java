package SingletonEager2;

/**
 * 恶汉式
 *      在静态代码块中创建该类对象
 */
public class Singleton {
    //私有构造方法
    private Singleton() {}
    //在成员位置创建该类的对象
    private static Singleton instance;
    static {
        instance = new Singleton();
    }
    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return instance;
    }
}