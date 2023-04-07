class Calculator {
    public void add(int a, int b) {
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    public void max(int a, int b) {
        System.out.println("Max is "+Math.max(a, b));
    }
}
public class hw2_Inheritance extends Calculation {
    public static void main(String args[]) {
        hw2_Inheritance cal = new hw2_Inheritance();
        int a=5;
        int b=6;
        cal.add(a,b);
        cal.max(a,b);
    }
}