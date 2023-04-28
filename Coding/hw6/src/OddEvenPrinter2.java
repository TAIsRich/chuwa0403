import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter2 {

    private final ReentrantLock lock;
    private final Condition oddCondition;
    private final Condition evenCondition;
    private int number;

    public OddEvenPrinter2() {
        this.lock = new ReentrantLock();
        this.oddCondition = lock.newCondition();
        this.evenCondition = lock.newCondition();
        this.number = 1;
    }

    public void printOdd() {
        lock.lock();
        try {
            while (number <= 9) {
                System.out.println("Thread 1 (odd): " + number);
                number++;
                evenCondition.signal();
                if (number <= 9) {
                    oddCondition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            while (number <= 10) {
                System.out.println("Thread 2 (even): " + number);
                number++;
                oddCondition.signal();
                if (number <= 10) {
                    evenCondition.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter2 printer = new OddEvenPrinter2();

        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
