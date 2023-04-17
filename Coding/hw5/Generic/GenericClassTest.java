package Generic;

/**
 * @author Min He
 * @date 15/4/2023 19:31 PM
 * */
public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        GenericClass<String> obj2 = new GenericClass<>("I will find a job !!");
        System.out.println(obj2.getObj());

        GenericClass<Double> obj3 = new GenericClass<>(29.99999999);
        System.out.println(obj3.getObj());
    }
}
