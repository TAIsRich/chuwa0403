package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q_23_b {
    private static volatile int count = 0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 2 != 0) {
                        System.out.println("Thread-0: " + count);
                        count++;
                        condition.signal();
                    } else {
                        condition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                while (count <= 10) {
                    if (count % 2 == 0) {
                        System.out.println("Thread-1: " + count);
                        count++;
                        condition.signal();
                    } else {
                        condition.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
