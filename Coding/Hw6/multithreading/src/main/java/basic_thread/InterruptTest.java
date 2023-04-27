package basic_thread;

import org.junit.Test;

//import static jdk.javadoc.internal.tool.Main.execute;

public class InterruptTest {

    public static void main (String [] args) throws InterruptedException {
        InterruptTest instance = new InterruptTest();
        Thread t = new MyThreadWithIsInterrupted();
        instance.execute(t);
    }

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
        t.start();
        Thread.sleep(1);
        t.interrupt();
        System.out.println("IN here");
//        t.join();
        System.out.println("end execution");
    }
}

class MyThreadWithIsInterrupted extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted? can be interrupt why? 为什么用isInterrupt（）后不被中断
        // Question, where is isInterrupted() from? Thread
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
        for (int i = 0; i < 100000; i++){}
        System.out.println(" Yes!"); //interrupt之后会持续执行到结束
    }
}

class WhileTrue extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted? no！
        while (true) { //不会被terminate
            n++;
            System.out.println(n + " hello!");
            int k = 1;
            while (k < 100000)
                k += 1;
//            if (n == 100)
//                break;
        }
//        System.out.println(" Yes!");
    }
}


class SleepForever extends Thread {
    @Override
    public void run() {
        int n = 0;
        // Question, can be interrupted? Yes it can
        try {
            Thread.sleep(5000 * 1000);
        } catch (InterruptedException e) {
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}
