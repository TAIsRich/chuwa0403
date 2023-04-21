package com.richard.multithreading.m6_util_concurrent_locks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 * @Description
 * condition必须从lock中来，这样signalAll()才能通知到对应的等待中的线程
 * lockA 的condition 能唤醒使用了 lockA 的等待中的线程。不能唤醒 lockB 的。
 * Condition提供的await()、signal()、signalAll()原理和synchronized锁对象的wait()、notify()、notifyAll()是一致的，并且其行为也是一样的：
 *
 * await()会释放当前锁，进入等待状态；
 * signal()会唤醒某个等待线程；
 * signalAll()会唤醒所有等待线程；
 * 唤醒线程从await()返回后需要重新获得锁。
 *
 * Condition可以替代wait和notify；
 * Condition对象必须从Lock对象获取。
 */

public class ConditionLearn {

    public static void main(String[] args) throws InterruptedException {

        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();

        // create 5 threads
        for (int i = 0; i < 5; i++) {
            //execute task
            Thread consumer = new Thread(() -> {
                while (true) {
                    try {
                        String task = q.getTask();
                        System.out.println(task + " is executed");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println("Consumer Thread " + i + " start...");
            consumer.start();
            ts.add(consumer);
        }

        Thread producer = new Thread(() -> {

            System.out.println("Producer thread starts...");
            // create task
            for (int i = 0; i < 15; i++) {
                String s = "t-" + (int) (Math.random() * 1000);
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        producer.join();

        Thread.sleep(1000);
        for (Thread t : ts) t.interrupt();

    }
}

class TaskQueue extends Thread {
    private final Lock lock = new ReentrantLock();

    /**
     * 可见，使用Condition时，引用的Condition对象必须从Lock实例的newCondition()返回，
     * 这样才能获得一个绑定了Lock实例的Condition实例。
     */
    private final Condition condition = lock.newCondition();

    private final Queue<String> queue = new LinkedList<>();

    public void addTask (String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }

            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}