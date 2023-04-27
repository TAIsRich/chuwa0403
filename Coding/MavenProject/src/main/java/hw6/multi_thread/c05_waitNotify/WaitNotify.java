package hw6.multi_thread.c05_waitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaitNotify {
    public static void main(String[] args) {
        TaskQueue q= new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();

        for(int i = 0;i<5;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    while(true){
                        try{
                            String s= q.getTask();
                            System.out.println("execute task: "+s);
                        }catch (InterruptedException e){
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
    }

}

class TaskQueue{
    Queue<String> queue = new LinkedList<>();
    public synchronized void addTask(String s){
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException{
        while(queue.isEmpty()){
            // wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()
            // when can we use this lock?
            // after wait(), thread become waiting status
            // no return of wait() and when the thread is awake, the next line will be executed
            this.wait();
        }
        return queue.remove();
    }
}
