package com.chuwa.t08_multithreading.syn;

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
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    monitor.notify();
                    System.out.println(Thread.currentThread().getName() + "notified");
                    try {
                        if (value < 11) {
                            System.out.println(Thread.currentThread().getName() + "wait");
                            monitor.wait();
                            System.out.println(Thread.currentThread().getName() + "waited");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "end loop");
                }
            }
            System.out.println(Thread.currentThread().getName() + "exit");
        }
    }
}