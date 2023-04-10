package pattern.singleton.destroy.reflection;

// 测试用反射来破坏单例

import java.lang.reflect.Constructor;

public class Reflection {

    public static void main(String[] args) throws Exception {

        // 1. 获取Singleton的字节码对象
        Class<Singleton> clazz = Singleton.class;

        // 2. 获取无参构造方法对象
        Constructor<Singleton> cons = clazz.getDeclaredConstructor();

        // 3. 取消访问检查
        cons.setAccessible(true);

        // 4. 创建Singleton对象
        Singleton s1 = cons.newInstance();
        // 会抛出异常如果我们在Singleton中设定好了解决办法
        Singleton s2 = cons.newInstance();
        System.out.println(s1 == s2); // false 破坏成功

    }

}
