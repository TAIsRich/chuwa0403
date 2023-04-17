public class GenericMultiArg {
    public static <T1, T2, T3> void print(T1 a, T2 b, T3 c) {
        System.out.println("This is x = " + a);
        System.out.println("This is y = " + b);
        System.out.println("This is z = " + c);
    }

    public static void main(String[] args) {
        print(1, "2", 3L);
    }
}
