package singleton;

public class Client {
    public static void main(String[] args){
        Singleton ins = Singleton.getInstance();
        Singleton ins1 = Singleton.getInstance();

        System.out.println(ins == ins1);
    }
}
