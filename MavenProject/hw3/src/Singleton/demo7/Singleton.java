package Singleton.demo7;

import java.io.Serializable;

/**饿汉式:静态成员变量**
 */
public class Singleton implements Serializable {
    //1,私有构造方法
    private Singleton(){}

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
