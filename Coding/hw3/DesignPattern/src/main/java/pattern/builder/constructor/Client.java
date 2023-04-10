package pattern.builder.constructor;

// 用创建者来构造对象适用于这个对象有可选参数的时候进行构造很好用

public class Client {

    public static void main(String[] args) {

        // 创建手机对象，通过构建者对象创建手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("samsung")
                .memory("kinston")
                .mainboard("asus")
                .build();

        System.out.println(phone);

    }
}
