package print_number;

import javax.print.DocFlavor;

public class PrintNumber {


    private volatile static int cnt = 0;

    public static void main(String [] args) {
        Thread t1 = new Thread(() -> print());
        Thread t2 = new Thread(() -> print());
        Thread t3 = new Thread(() -> print());
        t1.start(); t2.start(); t3.start();
    }
    public static synchronized void print() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + cnt++);
                }
            }

    }



