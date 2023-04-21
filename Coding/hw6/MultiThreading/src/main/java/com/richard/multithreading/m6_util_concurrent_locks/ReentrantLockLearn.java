package com.richard.multithreading.m6_util_concurrent_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 *
 * @Description
 * ReentrantLock可以替代synchronized进行同步；
 * ReentrantLock获取锁更安全；
 * 必须先获取到锁，再进入try {...}代码块，最后使用finally保证释放锁；
 * 可以使用tryLock()尝试获取锁。
 */

public class ReentrantLockLearn {

    public static void main(String[] args) {
        CounterReentrant counterReentrant = new CounterReentrant();

        Thread t1 = new Thread(() ->{
            int n = 20;

            while (n-- > 0) {
                counterReentrant.add(2);
                System.out.println("t1 adds 2: " + counterReentrant.getCount());
            }
        });

        Thread t2 = new Thread(() -> {
            int n = 20;

            while (n-- > 0) {
                counterReentrant.add(100);
                System.out.println("t2 adds 100: " + counterReentrant.getCount());
            }
        });

        t1.start();
        t2.start();
        System.out.println("Main Ends!");

    }

}

class CounterSynchronized {

    private int count;

    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }

    public int getCount() {
        return count;
    }

}

class CounterReentrant {

    private final Lock lock = new ReentrantLock();
    private int count;

    public int getCount() {
        return count;
    }

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

}