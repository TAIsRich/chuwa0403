package Question24;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class SynchronizedSolution {

    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(SynchronizedSolution::printNumber);
        Thread t2 = new Thread(SynchronizedSolution::printNumber);
        Thread t3 = new Thread(SynchronizedSolution::printNumber);

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int cnt = 10;

        while (cnt-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        SynchronizedSolution.class.notifyAll();
    }
}
