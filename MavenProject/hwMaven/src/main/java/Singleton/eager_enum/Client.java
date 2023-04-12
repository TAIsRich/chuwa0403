package Singleton.eager_enum;

public class Client {
    public static  void main(String[] args) {

        Singleton.lazy1.Singleton instance = Singleton.lazy1.Singleton.getInstance();

        Singleton.lazy1.Singleton instance1 = Singleton.lazy1.Singleton.getInstance();


        System.out.println(instance == instance1);
    }
}
