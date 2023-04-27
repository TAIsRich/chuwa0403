package com.richard.multithreading.m3_syncornized;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 * @Description 用object当锁，不同thread用不同锁去访问同一变量，会失效。
 */

public class SynchronizedThreadsFailed {

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[] {
                new AddThread(),
                new DecThread(),
                new AddThread2(),
                new DecThread2()
        };

        for (Thread t : ts) t.start();

        for (Thread t : ts) t.join();

        System.out.println("永远在变，因为用了不同的锁： -> " + CounterFailed.studentCount);
        System.out.println("永远为0， 因为使用了同一把锁： -> " + CounterFailed.teacherCount);
    }
}

/**
 * Locker
 */
class CounterFailed {
    public static final Object LOCK_STUDENT = new Object();
    public static final Object LOCK_TEACHER = new Object();
    public static final Object LOCK_COMMON = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (CounterFailed.LOCK_STUDENT) {
                //System.out.println("Student Add");
                CounterFailed.studentCount += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (CounterFailed.LOCK_TEACHER) {
                //System.out.println("Student Dec");
                CounterFailed.studentCount -= 1;
            }
        }
    }
}

class AddThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (CounterFailed.LOCK_COMMON) {
                //System.out.println("Teacher Add");
                CounterFailed.teacherCount += 1;
            }
        }
    }
}

class DecThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (CounterFailed.LOCK_COMMON) {
                //System.out.println("Teacher Dec");
                CounterFailed.teacherCount -= 1;
            }
        }
    }
}
