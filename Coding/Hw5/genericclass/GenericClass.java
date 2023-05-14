public class GenericClass<T> {
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj() + " " + obj1.getObj().getClass());

        GenericClass<Double> obj2 = new GenericClass<>(15.777755);
        System.out.println(obj2.getObj() + " " + obj2.getObj().getClass());

        GenericClass<String> obj3 = new GenericClass<>("Yayy! That's my first Generic Class.");
        System.out.println(obj3.getObj() + " " + obj3.getObj().getClass());
    }
}