package com.richard.multithreading.m2_basic_thread_handling;

import org.junit.Test;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 * @Description
 * 中断线程就是其他线程给该线程发送一个信号
 * 该线程收到信号后结束执行run()方法，使得自身线程能够立刻结束
 */

public class InterruptTest {
    /**
     * @Description
     * 仔细看下面的代码，main线程通过调用t.interrupt()方法中断t线程
     * 但是要注意interrupt()方法仅仅向t线程发出了"中断请求"
     * 至于t线程是否能够立刻响应，需要看具体的代码。
     * t线程的while循环会检测isInterrupted(),所以该代码可以正确响应interrupt()请求
     * 使得自身立刻结束运行run()方法
     */

    @Test
    public void testIsInterrupted() throws InterruptedException {
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);
    }

    @Test
    public void testInterruptWhileTrue() throws InterruptedException {
        Thread t = new WhileTrue();
        execute(t);
    }

    @Test
    public void testInterruptSleep() throws InterruptedException {
        Thread t = new SleepForever();
        execute(t);
    }

    private void execute(Thread t) throws InterruptedException {

        // NEW -> RUNNABLE
        t.start();
        // Question: Who sleeps?
        // Answer: The thread that is currently executing.
        Thread.sleep(2000); // 暂停2 mm

        // 这个时候当前线程已经暂停，相当于 t.interrupt() 要等相应的时间才能执行

        // Question: Who is interrupted? 一定会被成功中断么？
        // Answer: t will be interrupted.
        //         Can be interrupted or not depends on the code that this thread is executing.
        t.interrupt(); // 中断t线程

        // Question: Who is running and who stopped?
        // Answer: t is running and current thread will stop to wait for t.
        t.join(); // 等待t线程结束

        System.out.println("End");

    }

}

class MyThreadWithIsInterrupted extends Thread {

    @Override
    public void run() {
        int n = 0;
        // Question 1: Can be interrupted?
        // Answer: Yes but won't throw exception

        // Question 2: Where is isInterrupted() from?
        // Answer: Inherit from Thread

        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}

class WhileTrue extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question 3: Can be interrupted?
        // Answer: No

        while (true) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}

class SleepForever extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question 4: Can be interrupted?
        // Answer: Yes and will throw exceptions
        // Why catch this exception:
        // Because this thread can be interrupt while sleeping.

        try {
            Thread.sleep(5000 * 1000);
        } catch (InterruptedException e) {
            System.out.println("SleepForever thread is interrupted");
            e.printStackTrace();
        }
    }
}
