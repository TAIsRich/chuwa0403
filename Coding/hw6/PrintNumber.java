package hw6;

public class PrintNumber {
    private static int n = 1;

    public static void main(String[] args) {
        new Thread(()-> printNumber()).start();
        new Thread(()-> printNumber()).start();
        new Thread(()-> printNumber()).start();

    }
   private static synchronized void printNumber(){
        int count = 10;
        while(count-->0){
            System.out.println(Thread.currentThread().getName() + ":" + n++);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       PrintNumber.class.notifyAll();
   }
}
