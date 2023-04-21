public class AtomicLearn {
    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( ! var.compareAndSet(prev, next));
        return next;
    }
}
class IdGenerator {
    AtomicLong var = new AtomicLong(0);
    public long getNextId() {
        return var.incrementAndGet();
    }
}
public class ConcurrentCollection {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>(16);
        map.put("A", "1");
        map.put("B", "2");
        String a = map.get("A");
        Map<Object, Object> unsafeMap = new HashMap<>(16);
        Map<Object, Object> threadSafeMap = Collections.synchronizedMap(unsafeMap);
    }
}
public class ConditionLearn {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread consumer = new Thread(() -> {
                while (true) {
                    try {
                        String task = q.getTask();
                        System.out.println(task + " is executed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("Consumer Thread " + i + " start...");
            consumer.start();
            ts.add(consumer);
        }
        Thread producer = new Thread() {
            @Override
            public void run() {
                System.out.println("Producer Thread Run...");
                for (int i = 0; i < 15; i++) {
                    String s = "t-" + (int) (Math.random() * 1000);
                    System.out.println("add task: " + s);
                    q.addTask(s);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();
        producer.join();
        Thread.sleep(1000);
        for (Thread t : ts)
            t.interrupt();
    }
}
class TaskQueue extends Thread {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<String> queue = new LinkedList<>();
    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
public class ReadWriteLockLearn {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();
        List<Thread> tWrites = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread tRead = new Thread(() -> {
                int[] nums = counter.get();
                for (int num : nums)
                    System.out.print(num + " ");
                System.out.println();
            });
            tRead.start();
            threads.add(tRead);
        }
        for (int j = 0; j < 2; j++) {
            Thread tWrite = new Thread(() -> {
                for (int i = 0; i < 5; i++)
                    counter.inc(i);
            });
            tWrite.start();
            tWrites.add(tWrite);
        }
        Thread.sleep(15000);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
class Counter {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock rLock = rwLock.readLock();
    private final Lock wLock = rwLock.writeLock();
    private final int[] counts = new int[10];
    public void inc(int index) {
        wLock.lock();
        try {
            counts[index] += 1;
        } finally {
            wLock.unlock();
        }
    }
    public int[] get() {
        rLock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rLock.unlock();
        }
    }
}
public class ReentrantLockLearn {
    public static void main(String[] args) {
        CounterReentrant counterReentrant = new CounterReentrant();
        Thread t1 = new Thread(() -> {
            int n = 20;
            while (n-- > 0) {
                counterReentrant.add(2);
                System.out.println("t1 add 2: " + counterReentrant.getCount());
            }
        });
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int n = 20;
                while (n-- > 0) {
                    counterReentrant.add(100);
                    System.out.println("t2 add 100: " + counterReentrant.getCount());
                }
            }
        };
        t1.start();
        t2.start();
        System.out.println("Main end");
    }
}
class CounterSynchronized {
    private int count;
    public void add(int n) {
        synchronized (this) {
            count += n;
        }
    }
    public int getCount() {
        return count;
    }
}
class CounterReentrant {
    private final Lock lock = new ReentrantLock();
    private int count;
    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
    public int getCount() {
        return count;
    }
}
public class StampedLockLearn {
    public static void main(String[] args) {
        Point point = new Point();
        Thread tWrite = new Thread(() -> {
            for (int i = 0; i < 3; i++)
                point.move(100, 200);
            System.out.println("Write Done");
        });
        Thread tRead = new Thread(() -> System.out.println(point.distanceFromOrigin()));
        tWrite.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tRead.start();
    }
}
class Point {
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x;
        double currentY = y;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}