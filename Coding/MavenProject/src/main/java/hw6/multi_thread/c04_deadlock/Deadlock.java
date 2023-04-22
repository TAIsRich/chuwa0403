package hw6.multi_thread.c04_deadlock;

public class Deadlock {
    // to avoid: 线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[]{
                new Thread(()->{
                    while(true){
                        Counter.add(2);
                    }
                }),
                new Thread(()->{
                    while (true){
                        Counter.dec(2);
                    }
                })
        };

        for (Thread t:ts)
            t.start();
        for (Thread t:ts)
            t.join();
        System.out.println("end");
    }
}

class Counter{
    public static final Object LOCK_A = new Object();
    public static final Object LOCK_B = new Object();

    private static int value= 0;
    private static int another = 0;

    public static void add(int m){
        synchronized (LOCK_A){
            value+=m;
            synchronized (LOCK_B){
                another += m;
            }
        }

        System.out.println("val: "+value+" "+another);
    }

    public static void dec(int m){
        synchronized (LOCK_B){
            another -=m;
            synchronized (LOCK_A){
                value -= m;
            }
        }
        System.out.println("val: "+value+" "+another);
    }
}
