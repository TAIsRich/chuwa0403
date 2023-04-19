package features.lambda;

/**
 * @author Min He
 * @date 4/16/23 18:19 PM
 */

@FunctionalInterface
public interface Foo {

    String aMethod(String string);

    default String defaultBar(){
        String s = "default Bar Method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon(){
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
