package hw6.multi_thread.c02_basic_thread_handling;

public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Thread start");
            try{
                Thread.sleep(2000); // who sleep? t
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread end");
        });

        System.out.println("Main start");
        t.start();
        try{

            System.out.println("Main thread is stopped and waiting for t thread end");
            t.join();
            // main thread wait for t. Main status is (Timed?) Waiting.
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main stop");
    }
}
