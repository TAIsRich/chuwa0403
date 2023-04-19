package lambda;

@FunctionalInterface
public interface Foo {
    String aMethod(String string);

    default String defaultBar() {
        String s = "defaultBar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
