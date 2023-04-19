public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
public class DIMImpl implements DIML {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
public interface DIML {
    static final String BLOG = "is Chuwa a";
    int add(int a, int b);
    default int substract(int a, int b) {
        return a - b;
    }
    static String blogName() {
        return BLOG;
    }
}