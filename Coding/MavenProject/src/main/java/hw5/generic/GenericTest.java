package hw5.generic;

public class GenericTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        // GenericClass<int> obj = new GenericClass<>(5);
        // should be an Object;
        // Object is the super class of all other classes
        /*
        T – Type
        E – Element
        K – Key
        N – Number
        V – Value
         */

        GenericClass<Double> obj2 = new GenericClass<>(5.2);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("S");
        System.out.println(obj3.getObj());

    }
}

