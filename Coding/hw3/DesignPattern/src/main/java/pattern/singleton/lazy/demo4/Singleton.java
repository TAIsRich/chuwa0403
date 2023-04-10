package pattern.singleton.lazy.demo4;

/*
 * @Description Lazy - static inner class
 * @Author Richard
 */

public class Singleton {

    // 1. 私有构造方法
    private Singleton() {}

    // 2. 定义一个静态内部类
    private static class SingletonHolder {
        // 3. 在内部类声明并且初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    // 4. 提供公共访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
