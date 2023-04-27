package com.chuwa.learn.hw6;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class OddEvenPrinter2 {
    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition condition = lock.newCondition();
    private static int count = 1;

    public static void main(String[] args) {
        PrintRunnable2 runnable2 = new PrintRunnable2();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
    }

    static class PrintRunnable2 implements Runnable{
        @Override
        public void run(){
            lock.lock();
            while(count <= 10){
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                condition.signal();
                try{
                    if(count < 11){
                        condition.await();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            lock.unlock();
        }
    }
}
