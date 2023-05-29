package hw6.multi_thread.c03_syncronized;

public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts= new Thread[]{
                new AddStudentTread(),
                new DecStudentThread(),
                new AddTeacherTread(),
                new DecTeacherThread()
        };

        for(Thread t: ts){
            t.start();
        }

        for (Thread t: ts){
            t.join();
        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }
}

// lockers
class Counter {
    public static final Object LOCK_STUDENT = new Object();
    public static final Object LOCK_TEACHER = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentTread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i< 100;i++){
            synchronized (Counter.LOCK_STUDENT){
                Counter.studentCount += 1;
                System.out.println("add s");
            }
        }
    }
}

class DecStudentThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i< 100;i++){
            synchronized (Counter.LOCK_STUDENT){
                Counter.studentCount -= 1;
                System.out.println("dec s");
            }
        }
    }
}

class AddTeacherTread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i< 100;i++){
            synchronized (Counter.LOCK_TEACHER){
                Counter.teacherCount += 1;
                System.out.println("add t");
            }
        }
    }
}

class DecTeacherThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i< 100;i++){
            synchronized (Counter.LOCK_TEACHER){
                Counter.teacherCount -= 1;
                System.out.println("dec t");
            }
        }
    }
}

