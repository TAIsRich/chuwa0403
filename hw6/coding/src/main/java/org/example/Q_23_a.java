package org.example;

public class Q_23_a {
    private static volatile int count = 0;
    private static final Object lock = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (count <= 10) {
                    while (count % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count % 2 == 0) {
                        System.out.println("Thread-0: " + count);
                    }
                    count++;
                    lock.notify();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                while (count < 10) {
                    while (count % 2 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count % 2 == 1) {
                        System.out.println("Thread-1: " + count);
                    }
                    count++;
                    lock.notify();
                }
            }
        });

        t1.start();
        t2.start();
    }

}

