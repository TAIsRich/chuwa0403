package Singleton.demo8;

import java.io.Serializable;

/**饿汉式:静态成员变量**
 */
public class Singleton implements Serializable {
    private static boolean flag = false;
    //1,私有构造方法
    private Singleton() {
        synchronized (Singleton.class) {
            //判断flag是否为true,true: 非第一次访问，抛异常。
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            flag = true;
        }
    }

    //2，定义一个静态内部类
    private static class SingletonHolder{
        //在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }
    //提供一个公共的访问方式，让外界访问该对象
    public static Singleton getInstance(){

        return SingletonHolder.INSTANCE;
    }
}
