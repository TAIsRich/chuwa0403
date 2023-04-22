package Question23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ReentrantLockSolution {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int n = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (n <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + n++);
                    condition.signalAll();
                }
                try {
                    if (n < 11) {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
