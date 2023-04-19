package features.interface_method;

/**
 * @author Min He
 * @date 4/16/23 17:05 PM
 */
public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());

    }
}
