package Singleton.demo5;
/**静态内部类*/
public class Singleton {
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
