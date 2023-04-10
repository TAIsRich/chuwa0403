package Singleton.demo2;
/**饿汉式：静态代码块*/
public class Singleton {

    //私有构造方法
    private Singleton(){}

    //声明Singleton 类的成员变量
    private static Singleton instance;// null

    //在代码块中进行复制
    static{
        instance = new Singleton();
    }

    //对外提供获取该类的对象的变量
    public static Singleton getInstance(){
        return instance;
    }

}
