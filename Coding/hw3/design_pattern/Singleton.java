/*
 * involves only one class which is responsible to make sure there is no more than one instance; 
 * it does it by instantiating itself and in the same time it provides a global point of access to that instance. 
 * The singleton class ensures the same instance can be used from everywhere, preventing direct invocation of the singleton constructor.
 * 
 * Ensure that only one instance of a class is created.
 * Provide a global point of access to the object.
 * 
 * use: design of logger, configuration
 */

public class SingletonL{
    public static void main(String[] args) {
        SingletonEager eager1 = SingletonEager.getInstance();
        SingletonEager eager2 = SingletonEager.getInstance();
        System.out.println(eager1 == eager2);
    }
}

/**
 * Eager load
 * 
 */
class SingletonEager{
    // private static variable
    private static SingletonEager instance = new SingletonEager();

    /* or use static block
    private static SingletonEager instance;
    static{
        instance = new SingletonEager();
    }
    */ 

    // private constructor: avoid creating new instance
    private SingletonEager(){}

    // static get Instance method: without instance of the object, we could get
    public static SingletonEager getInstance(){
        return instance;
    }
}

/**
 * Lazy load
 */
class SingletonLazy{

    private static SingletonLazy instance;

    private SingletonLazy(){}

    // synchronized promise only one thread will use this method
    // however the method is synchronized so it causes slow performance
    public static synchronized SingletonLazy getInstanceBad(){
        // read operation is multi-thread safe
        // not nessary to add lock before read
        if(instance == null){
            // write operation is not safe
            instance = new SingletonLazy();
        }
        return instance;
    }

    // double check locking
    public static SingletonLazy getInstance(){
        // if not null, not need to wait
        if(instance == null){
            synchronized(SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}

