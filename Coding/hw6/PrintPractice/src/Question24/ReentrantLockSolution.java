package Question24;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ReentrantLockSolution {

    private static ReentrantLock lock = new ReentrantLock();
    private static int n = 1;

    public static void main(String[] args) {
        new Thread(ReentrantLockSolution::printNumber).start();
        new Thread(ReentrantLockSolution::printNumber).start();
        new Thread(ReentrantLockSolution::printNumber).start();
    }

    private static void printNumber() {
        lock.lock();
        try {
            int cnt = 10;

            while (cnt-- > 0) System.out.println(Thread.currentThread().getName() + ": " + n++);
        } finally {
            lock.unlock();
        }
    }

}
