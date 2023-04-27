public class Daemon {
    public static void main(String[] args) {
        Thread tPpl = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God());
        tGod.setDaemon(true);
        tGod.start();
        tPpl.start();
        tGod2.setDaemon(true);
        tGod2.start();
        System.out.println("Main end");
    }
}
class People implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ppl live");
        }
        System.out.println("People thread end");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}
public class InterruptTest {
    @Test
    public void testIsInterrupted() throws InterruptedException {
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);
    }
    @Test
    public void testInterruptWhileTrue() throws InterruptedException {
        Thread t = new WhileTrue();
        execute(t);
    }
    @Test
    public void testInterruptSleep() throws InterruptedException {
        Thread t = new SleepForever();
        execute(t);
    }
    private void execute(Thread t) throws InterruptedException {
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        t.join();
        System.out.println("end");
    }
}
class MyThreadWithIsInterrupted extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}

class WhileTrue extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (true) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}


class SleepForever extends Thread {
    @Override
    public void run() {
        int n = 0;
        try {
            Thread.sleep(5000 * 1000);
        } catch (InterruptedException e) {
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
    }
}
public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread end");
        });
        System.out.println("Main start");
        t.start();
        try {
            System.out.println("Main thread is stopped and waiting for t thread end");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stop");
    }
}
public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("t thread starts...");
            try {
                System.out.println("t thread starts to sleep 5 second");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t thread done");
        });
        System.out.println("Main thread starts...");
        t.start();
        Thread.sleep(3000);
        System.out.println("Main thread starts to sleep 3 seconds");
        System.out.println("Main thread done");
    }
}