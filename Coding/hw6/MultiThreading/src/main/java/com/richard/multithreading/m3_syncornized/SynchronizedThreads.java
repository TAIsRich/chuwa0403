package com.richard.multithreading.m3_syncornized;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 * @Description 用object当锁，不同thread用不同锁去访问同一变量，会失效。
 */

public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[] {
                new AddStudentThread(),
                new DecStudentThread(),
                new AddTeacherThread(),
                new DecTeacherThread()
        };

        // 依次启动每一个线程，但是哪个线程先开始，哪个后开始是不可控的
        // 但是无论是Student还是Teacher，都会使用一个锁来加减其对应的数量
        for (Thread t : ts) t.start();

        // 当前线程等待所有ts中的线程执行完毕
        for (Thread t : ts) t.join();

        System.out.println("Student: " + Counter.studentCount);
        System.out.println("Teacher: " + Counter.teacherCount);
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
        for (int i = 0; i < 10; i++) {
            synchronized (Counter.LOCK_STUDENT) {
                System.out.println("Student Add");
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter.LOCK_STUDENT) {
                System.out.println("Student Dec");
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter.LOCK_TEACHER) {
                System.out.println("Teacher Add");
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter.LOCK_TEACHER) {
                System.out.println("Teacher Dec");
                Counter.teacherCount -= 1;
            }
        }
    }
}
