package java8.features.default_interface_method;

public class Client {

    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.subtract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
