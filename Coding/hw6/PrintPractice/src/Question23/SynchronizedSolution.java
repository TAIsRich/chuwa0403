package Question23;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class SynchronizedSolution {

    private static final Object MONITOR = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (MONITOR) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    MONITOR.notifyAll();
                    try {
                        if (value < 11) {
                            MONITOR.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
