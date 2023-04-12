package SingletonLazy3;

/**
 * 双重检查方式
 */
public class Singleton {
    //私有构造方法
    private Singleton() {}
    private static Singleton instance;
    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if(instance == null) {
            synchronized (Singleton.class) {
                //抢到锁之后再次判断是否为null
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}