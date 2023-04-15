package pattern.singleton.destroy.serialization;

// 测试使用反射破坏单列模式

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

    public static void main(String[] args) throws Exception {

        //writeObject2File();
        readObjectFromFile();
        readObjectFromFile();

        // 如果没overwrite readResolve()方法，地址不同，已经破坏了单列模式

    }

    // 从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {

        // 1. 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/zhuhaotian/Documents/Chuwa/chuwa0403/Coding/hw3/DesignPattern/a.txt"));

        // 2. 读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        // 3. 释放资源
        ois.close();
    }

    // 向文件中写数据（对象）
    public static void writeObject2File() throws Exception {

        // 1. 获取Singleton对象
        Singleton instance = Singleton.getInstance();

        // 2. 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/zhuhaotian/Documents/Chuwa/chuwa0403/Coding/hw3/DesignPattern/a.txt"));

        // 3. 写对象
        oos.writeObject(instance);

        // 4. 释放资源
        oos.close();

    }
}
