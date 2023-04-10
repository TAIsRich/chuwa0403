package SingletonLazy1;

/**
 * 懒汉式
 *  线程不安全
 */
public class Singleton {
    //私有构造方法
    private Singleton() {}
    //在成员位置创建该类的对象
    private static Singleton instance;
    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}