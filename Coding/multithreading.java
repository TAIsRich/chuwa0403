public class CallableTest {
    public static void main(String[] args) {
        final int n = 10;
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() {
                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }
        };
        try {
            Integer call = sumTask.call();
            System.out.println(call);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t = new MyThread();
        t.start();
        System.out.println("***********");
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        Thread t3 = new Thread(() -> System.out.println("Start new thread by implementing Runnable with lambda"));
        t3.start();
        Callable<String> callable = new MyCallable();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Future<String> future = executor.submit(callable);
        list.add(future);
        Future<String> stringFuture = list.get(0);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            String s = future.get();
            System.out.println(s);
        }
        executor.shutdown();
    }
}
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}