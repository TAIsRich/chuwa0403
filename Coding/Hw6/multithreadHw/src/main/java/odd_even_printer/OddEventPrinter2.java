package odd_even_printer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEventPrinter2 {
    static ReentrantLock relock = new ReentrantLock();

    private static final Condition condition = relock.newCondition();

    private static int value = 1;

    public static void main(String[] args) {
        OddEventPrinter.PrintRunnable runnable = new OddEventPrinter.PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            relock.lock();
            while (value <= 10) {
                System.out.println(Thread.currentThread().getName() + ": " + value++);
                condition.signal();
                try {
                    if (value < 11) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
