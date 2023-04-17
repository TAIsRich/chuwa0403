package Coding.Features.default_interface_method;

public interface DIML {
    static final String BLOG = "is chuwa a";

    //abstract method
    abstract int add(int a, int b);

    //default method
    default int substract(int a, int b) {
        return a - b;
    }

    //static method
    static String blogName() {
        return BLOG;
    }
}
