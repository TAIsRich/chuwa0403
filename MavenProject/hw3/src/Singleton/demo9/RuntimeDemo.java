package Singleton.demo9;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        //获取runtime类的对象
        Runtime runtime = Runtime.getRuntime();
        //调用runtime的方法
        Process process = runtime.exec("ipconfig");
        //调取process对象的获取输入流的方法
        InputStream is = process.getInputStream();
        byte[] arr = new byte[1024*1024*100];
        int len = is.read(arr);
        System.out.println(new String(arr,0,len,"GBK"));

    }
}
