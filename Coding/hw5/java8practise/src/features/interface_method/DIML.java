package features.interface_method;
/**
 * @author Min He
 * @date 4/16/23 17:05 PM
 */
public interface DIML {
    static final String BLOG="IS CHUWA";

    int add(int a, int b);

    default int substract(int a, int b){
        return a-b;
    }
    static String blogName(){return BLOG;}
}
