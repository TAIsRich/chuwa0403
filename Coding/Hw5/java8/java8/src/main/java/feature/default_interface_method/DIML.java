package feature.default_interface_method;

public interface DIML {
    static final String BLOG = "is Chuwa a";

    int add(int a, int b);

    static String blogName() {return BLOG;}

    default int substract(int a, int b) {return a - b;}
}
