package hw6.multi_thread.c01_create;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
