package Coding.GenericPractice;

public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<Integer>(5);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<Double>(15.38495734857);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<String>("Yea");
        System.out.println(obj3.getObj());
    }
}
