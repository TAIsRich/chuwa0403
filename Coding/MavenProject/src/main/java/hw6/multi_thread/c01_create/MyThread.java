package hw6.multi_thread.c01_create;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}
