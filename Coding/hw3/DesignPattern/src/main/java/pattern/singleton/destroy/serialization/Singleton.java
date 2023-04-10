package pattern.singleton.destroy.serialization;

/*
 * @Description Lazy - static inner class
 * @Author Richard
 */

import java.io.Serializable;

public class Singleton implements Serializable {

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

    // 5. 会由于反序列化造成的破坏单例的解决办法
    // 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
