package Coding.generic;

public class GenericClassTest {

    public static void main(String[] args) {
        // Test for Integer type
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1); // Coding.generic.GenericClass@4517d9a3
        System.out.println(obj1.getObj()); // 5

        // Test for Double type
        GenericClass<Double> obj2 = new GenericClass<>(15.5689);
        System.out.println(obj2.getObj());

        // Test for String type
        GenericClass<String> obj3 = new GenericClass<>("This is a str");
        System.out.println(obj3.getObj());
    }
}
