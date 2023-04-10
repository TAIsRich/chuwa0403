package Singleton.demo4;
/**双重检查锁方式*/
public class Singleton {
    //1,私有构造方法
    private Singleton(){}

    //2,声明Singleton 类的成员变量
    private static Singleton instance;//只是声明一个类型变量，没有赋值

    //提供一个公共的访问方式，让外界访问该对象
    public static Singleton getInstance(){
        //第一次判断，如果instance 的值，不为null，不需要抢占锁，直接返回对象
        if(instance == null) {
            synchronized (Singleton.class) {
                //第二次判断
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
