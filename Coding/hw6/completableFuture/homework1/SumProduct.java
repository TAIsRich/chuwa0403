package hw6.completableFuture.homework1;

public class SumProduct {
    private int num1;
    private int num2;

    public SumProduct(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public static int sum(int num1,int num2){
        return num1 + num2;
    }
    public static int product(int num1,int num2){
        return num1*num2;
    }
    public static void printResult(int result){
        System.out.println("The result is : " + result);
    }

}
