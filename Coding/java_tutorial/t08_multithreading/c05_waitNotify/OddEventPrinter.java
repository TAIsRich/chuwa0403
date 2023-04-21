package c05_waitNotify;

public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;
    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            // synchronized : ⻔
            // ⻔⾥有资源
            // 买⼀把锁 monitor
            // t0, t1
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify(); // t0: monitor.notify() -> 持有同⼀把锁的
                    try {
                        if (value < 11) {
                            monitor.wait(); // 解锁 且进⼊Waiting
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
