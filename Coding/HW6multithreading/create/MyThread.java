package mutithreads.create;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Start new thread using extends thread");
    }
}
