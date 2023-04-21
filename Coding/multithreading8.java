public class ApiIntegration {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    public static CompletableFuture<String> getProductInformation() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.bestbuy.com/v1/products?format=json&apiKey=YOUR_API_KEY"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
    public static CompletableFuture<String> getReviews() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.yelp.com/v3/businesses/{business_id}/reviews"))
                .header("Authorization", "Bearer YOUR_API_KEY")
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world.openfoodfacts.org/api/v0/product/{barcode}.json"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
public class CompletableFutureApiLearn {
    @Test
    public void demo01() {
        CompletableFuture<String> completableFuture = new CompletableFuture();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete("Hello");
        });
        try {
            System.out.println(completableFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo02() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + ": Hello1");
            return "Hello1";
        });
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() ->
                System.out.println(Thread.currentThread() + ": Hello2"));
        try {
            System.out.println(cf2.isDone());
            Thread.sleep(1000);
            System.out.println(cf2.isDone());
            System.out.println(cf1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo03() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo04() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo05() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo06() {
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        CompletableFuture<CompletableFuture<String>> future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future2.get().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo07() {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
                    System.out.println("1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2");
                    return "Hello";
                })
                .thenCombine(CompletableFuture.supplyAsync(() -> {
                    System.out.println("3");
                    return " World";
                }), (s1, s2) -> s1 + s2);
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo08() {
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }
    @Test
    public void demo09() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
        try {
            combinedFuture.get();
            assertTrue(future1.isDone());
            assertTrue(future2.isDone());
            assertTrue(future3.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo10() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3)
        try {
            String combined = Stream.of(future1, future2, future3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));
            System.out.println(combined);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo11() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return 1;
        }).handle((f, e) -> {
            int i = 10 / 0;
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            System.out.println("complete");
            if (e == null) {
                System.out.println("calculate result： " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
public class FutureVsCompletableFuture {
    @Test
    public void testFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> futureResult = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 10 + 20;
        });
        try {
            System.out.println("Performing other tasks...");
            int result = futureResult.get();
            System.out.println("Result from the future: " + result);
            System.out.println("----");
            for (int i = 0; i < 7; i++) {
                System.out.println("step " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
    @Test
    public void testCompletableFuture() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10 + 20;
        });
        System.out.println("Performing other tasks...");
        completableFuture.thenAccept(result -> System.out.println("Result from the CompletableFuture: " + result));
        System.out.println("----");
        for (int i = 0; i < 7; i++) {
            System.out.println("step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}