public class ThreadPoolExample {
    @Test
    public void fixedThreadPool(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
    @Test
    public void cachedThreadPoolExample() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
    @Test
    public void singleThreadExecutorExample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
    @Test
    public void scheduledThreadPoolExample() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(() ->
                System.out.println("Task is running on thread " +
                        Thread.currentThread().getName()), 0, 2, TimeUnit.SECONDS);
    }
    @Test
    public void customThreadPoolExample() {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        long keepAliveTime = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int queueCapacity = 100;
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                new ArrayBlockingQueue<>(queueCapacity)
        );
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executorService.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }
}
public class WebCrawlerExample {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "https://chuwa.com",
                "https://chuwa.org",
                "https://chuwa.net"
        );
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String url : urls) {
            executorService.submit(() -> {
                try {
                    downloadAndSave(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void downloadAndSave(String urlString) throws IOException {
        URL url = new URL(urlString);
        String fileName = "output_" + url.getHost() + ".html";
        try (Scanner scanner = new Scanner(url.openStream());
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine());
                writer.newLine();
            }
            System.out.println("Downloaded and saved: " + fileName);
        }
    }
}