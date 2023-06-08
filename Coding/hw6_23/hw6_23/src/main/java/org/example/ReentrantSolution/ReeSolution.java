package org.example.ReentrantSolution;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ReeSolution {
    private static int count = 1;
    private static final int MAX_COUNT = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static boolean isOdd = true;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (count <= MAX_COUNT) {
                lock.lock();
                try {
                    if (isOdd) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = false;
                        evenCondition.signal();
                    } else {
                        oddCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Odd Thread");

        Thread evenThread = new Thread(() -> {
            while (count <= MAX_COUNT) {
                lock.lock();
                try {
                    if (!isOdd) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                        isOdd = true;
                        oddCondition.signal();
                    } else {
                        evenCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "Even Thread");

        oddThread.start();
        evenThread.start();
    }
}

class CounterReentrant {
    private final Lock lock = new ReentrantLock();
    private int count;

    public static int n = 10;

    public void add(int n) {
        while(this.n>0){
            lock.lock();
            try {
                count += 1;
                System.out.println(""+Thread.currentThread().getName()+count);
                this.n--;
                lock.notify();
                lock.wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }

    }

    public int getCount() {
        return count;
    }
}
