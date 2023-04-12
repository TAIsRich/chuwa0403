package Singleton.demo3;
/**懒汉式*/
public class Singleton {
    //1,私有构造方法
    private Singleton(){}
    //2,声明Singleton 类的成员变量
    private static volatile Singleton instance;

    //提供一个公共的访问方式，让外界访问该对象,线程安全的
    public static synchronized Singleton getInstance(){
        //判断instance 是否为null,如果为null.说明还没有创建类的对象，需要创建一个并返回
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
