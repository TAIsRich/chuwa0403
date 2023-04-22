package hw6;

public class OddEvenPrinterSynchronized {
    private static final Object lock = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyPrinter());
        Thread thread2 = new Thread(new MyPrinter());
        thread1.start();
        thread2.start();
    }

    static class MyPrinter implements Runnable {

        @Override
        public void run() {
            synchronized (lock){
                while(value <=10){
                    System.out.println(Thread.currentThread().getName() +":" + value++);
                    lock.notify();
                    try{
                        if(value < 11){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
