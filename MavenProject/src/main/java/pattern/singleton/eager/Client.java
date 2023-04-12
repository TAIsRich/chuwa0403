package pattern.singleton.eager;

public class Client {
    public static void main(String [] args) {
        EagerSingleton1 e1 = EagerSingleton1.getInstance();
        EagerSingleton1 e2 = EagerSingleton1.getInstance();

        System.out.println(e1 == e2);
    }
}
