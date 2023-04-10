package SingletonLazy2;

/**
 * 懒汉式
 *  线程安全
 */
public class Singleton {
    //私有构造方法
    private Singleton() {}
    //在成员位置创建该类的对象
    private static Singleton instance;
    //对外提供静态方法获取该对象
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}