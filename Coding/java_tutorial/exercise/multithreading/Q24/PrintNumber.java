package multithreading.Q24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintNumber {

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintRunnable(1, 10));
        Thread t2 = new Thread(new PrintRunnable(11, 20));
        Thread t3 = new Thread(new PrintRunnable(21, 30));

        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintRunnable implements Runnable {
        private final int start;
        private final int end;

        public PrintRunnable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
