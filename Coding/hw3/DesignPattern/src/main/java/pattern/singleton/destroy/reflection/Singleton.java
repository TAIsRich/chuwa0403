package pattern.singleton.destroy.reflection;

/*
 * @Description Lazy - static inner class
 * @Author Richard
 */

import java.io.Serializable;

public class Singleton implements Serializable {

    // 解决办法
    private static boolean flag = false;

    // 1. 私有构造方法
    private Singleton() {

        synchronized (Singleton.class) {
            // 判断flag的值是否是true
            // true：非第一次访问，直接抛异常
            // false：第一次访问，正常创建

            if (flag) {
                throw new RuntimeException("Can't initialize multiple objects");
            }
            flag = true;
        }

    }

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
