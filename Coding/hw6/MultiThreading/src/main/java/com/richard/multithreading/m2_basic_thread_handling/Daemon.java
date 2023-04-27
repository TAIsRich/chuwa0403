package com.richard.multithreading.m2_basic_thread_handling;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 * @Description
 * 守护线程是低优先级的线程，它的作用仅仅是为用户线程（非守护线程）提供服务。
 * 正是由于守护线程是为用户线程提供服务的，仅仅在用户线程处于运行状态时才会需要守护线程。
 * 一旦所有的用户线程都运行完毕，守护线程是无法阻止 JVM 退出。
 * 当程序只剩下守护线程的时候程序就会自动关闭。
 *
 * 守护线程的作用类似在后台静默执行，最典型的守护线程就是 JVM 的垃圾回收机制。
 *
 * 在守护线程中，编写代码一定注意：
 * 守护线程不能持有任何需要关闭的资源，例如打开文件等
 * 守护线程没有任何机会来关闭文件，这会导致数据丢失
 */

public class Daemon {
    public static void main(String[] args) {
        // question: 当其它线程都运行完后，守护线程会结束么？
        // answer: 会
        // question: 当 main 运行完后，守护线程会结束么？
        // answer: 不会

        // 但是其实谁先执行谁后执行是不确定的
        // 可以多运行几次，每一次的输出顺序都可能不太一样

        Thread tPpl = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God2());

        // 把 tGod 设置为守护进程
        tGod.setDaemon(true);
        tGod.start();
        tPpl.start();

        // 把 tGod2 设置为守护进程
        tGod2.setDaemon(true);
        // 当只剩下守护线程的时候，无论有多少个，JVM都会退出
        tGod2.start();
        System.out.println("Main end");
    }
}

class People implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ppl live: " + i);
            System.out.println("******************************");
        }

        System.out.println("People thread end");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("God 守护ing");
        }
    }
}

class God2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("God2 守护ing");
        }
    }
}
