package org.example;

public class Main {
    public static volatile int global_n = 0;
    public static void main(String[] args) throws InterruptedException {
        printNum ptn = new printNum();

        Thread t1 = new Thread(ptn);
        Thread t2 = new Thread(ptn);
        Thread t3 = new Thread(ptn);
        t1.start();
        //t1.join();
        t2.start();
        //t2.join();
        t3.start();
    }

    static class printNum implements Runnable{
        @Override
        public synchronized void run(){


                int n=10;
                while(n>0 && global_n<22){
                    n--;
                    global_n++;
                    System.out.println(Thread.currentThread().getName() + "  "+global_n);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

        }
    }
}