package com.chuwa.learn.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter2 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int value = 1;

    public static void main(String[] args) {
        new Thread(new OddPrinter()).start();
        new Thread(new EvenPrinter()).start();
    }

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (value <= 10) {
                lock.lock();
                try {
                    if (value % 2 == 0) {
                        oddCondition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": " + value++);
                        evenCondition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (value <= 10) {
                lock.lock();
                try {
                    if (value % 2 == 1) {
                        evenCondition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName() + ": " + value++);
                        oddCondition.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
