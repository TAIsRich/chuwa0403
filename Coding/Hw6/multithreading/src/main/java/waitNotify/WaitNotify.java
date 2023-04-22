package waitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    // 执行task
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task
                String s = "t-" + i;
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();
    Queue<String> queue1 = new LinkedList<>();

    public synchronized void addTask(String s) { //sychronized 整个方法，不同对象调用这个function的时候线程安全
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized void addTask2(String s) { //线程不安全， 对象1.addTask, 对象2.addTask
        this.queue.add(s);
        this.notifyAll();
    }
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait(); //调用的this锁，所以得用this。wait（）， wait方法不返回
        }
        return queue.remove();
    }
}
