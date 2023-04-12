package Singleton.lazy3;

public class Client {
    public static  void main(String[] args) {

        Singleton.eager1.Singleton instance = Singleton.eager1.Singleton.getInstance();

        Singleton.eager1.Singleton instance1 = Singleton.eager1.Singleton.getInstance();


        System.out.println(instance == instance1);
    }
}
