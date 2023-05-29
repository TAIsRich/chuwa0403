package hw6.multi_thread.c02_basic_thread_handling;

import com.sun.tools.javac.Main;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class InterruptTest {
    // other thread send this thread a signal, and this thread run
    public static void main(String[] args) {

    }

    @Test
    public void testIsInterrupted() throws InterruptedException{
        Thread t = new MyThreadWithIsInterrupted();
        // can be interrupted
        // but it is not ended, jump out of the loop and finish the last line
        execute(t);
    }

    @Test
    public void testInterruptWhileTrue() throws InterruptedException{
        Thread t = new WhileTrue();
        // can be interrupted
        // but with join, it will continue doing the loop
        execute(t);
    }

    @Test
    public void testInterruptSleep() throws InterruptedException{
        Thread t = new SleepForever(); // can be interrupted
        execute(t);
    }

    private void execute(Thread t) throws InterruptedException{
        t.start();
        Thread.sleep(2000); // main sleep
        //t.interrupt();
        //t.join();
        System.out.println("end");
    }
}

class MyThreadWithIsInterrupted extends Thread{
    @Override
    public void run() {
        int n = 0;
        while(!isInterrupted()){
            n++;
            System.out.println(n+" hello");
        }
        System.out.println("Interrupted");
    }
}

class WhileTrue extends Thread{
    @Override
    public void run() {
        int n = 0;
        while(true){
            n++;
            if(n % 100000000== 0)
                System.out.println(n+" hello");
        }
    }


}

class SleepForever extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(5000*1000);
        }catch (InterruptedException e){
            System.out.println("thread is interrupted");
            e.printStackTrace();
        }
    }
}
