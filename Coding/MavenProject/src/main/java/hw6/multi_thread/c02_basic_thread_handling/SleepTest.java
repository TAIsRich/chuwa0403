package hw6.multi_thread.c02_basic_thread_handling;

public class SleepTest {
    // who call sleep, who sleep
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println("t thread starts...");
            try{
                System.out.println("t thread stars to sleep 5 second");
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("t thread done");
        });

        System.out.println("main thread starts...");

        t.start();
        System.out.println("main thread starts to sleep 3 seconds");
        // why this line is before thread starts?
        Thread.sleep(3000); //  main become a timed waiting
        System.out.println("main done");
    }
}
