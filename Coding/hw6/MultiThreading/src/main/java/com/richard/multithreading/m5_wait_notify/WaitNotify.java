package com.richard.multithreading.m5_wait_notify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 * @Description
 * 多线程协调运行的原则就是：
 * 当条件不满足时，线程进入等待状态；当条件满足时，线程被唤醒，继续执行任务。
 */

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {

        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println("Execute task: " + s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            });

            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入 task
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
;        });

        add.start();
        add.join();
        Thread.sleep(100);

        for (Thread t : ts) t.interrupt();
    }
}

class TaskQueue {

    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        /**
         * 添加了元素进入q中
         * 唤醒所有正在因为q为空而等待的线程
         */
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {

        while (queue.isEmpty()) {
            /**
             * wait() 方法必须在当前获取的锁对象上调用，这里获取的是this锁，所以调用this.wait()
             * 调用 wait() 方法后，线程进入等待状态，wait()方法不会返回，
             * 直到将来某个时刻，线程从等待状态被其他线程唤醒后，
             * wait() 方法才会返回，然后继续执行下一条语句
             */
            this.wait();
        }

        return queue.remove();
    }
}
