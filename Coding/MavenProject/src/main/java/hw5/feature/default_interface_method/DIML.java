package hw5.feature.default_interface_method;

public interface DIML {
    static final String content = "hi there";

    int add(int a, int b);

    default int sub(int a, int b){
        return a-b;
    }

    static String print() {
        return content;
    }
}
