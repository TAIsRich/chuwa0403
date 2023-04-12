class Calculator {
    static int aXb(int a, int b)
    {
        return a * b;
    }
    static double aXb(double a, double b)
    {
        return a * b;
    }
}
class hw2_Encapsulation {
    public static void main(String[] args)
    {
        System.out.println(Calculator.aXb(3, 2));
        System.out.println(Calculator.aXb(1.2, 5.5));
    }
}