package com.chuwa.t08_multithreading.syn;

public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[]{
                new AddStudentThread(),
                new DecStudentThread(),
                new AddTeacherThread(),
                new DecTeacherThread()

        };
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }

}

/**
 * Locker
 */
class Counter {
    public static final Object LOCK_STUDENT = new Object();
    public static final Object LOCK_TEACHER = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.LOCK_STUDENT) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.LOCK_STUDENT) {
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.LOCK_TEACHER) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.LOCK_TEACHER) {
                Counter.teacherCount -= 1;
            }
        }
    }
}