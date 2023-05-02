import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnlineStoreExceptionHandling {

    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static CompletableFuture<String> fetchProducts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Error fetching products: " + ex.getMessage());
                    return "[]";
                });
    }

    public static CompletableFuture<String> fetchReviews() {
        String url = "https://jsonplaceholder.typicode.com/comments";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Error fetching reviews: " + ex.getMessage());
                    return "[]";
                });
    }

    public static CompletableFuture<String> fetchInventory() {
        String url = "https://jsonplaceholder.typicode.com/albums";
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .exceptionally(ex -> {
                    System.err.println("Error fetching inventory: " + ex.getMessage());
                    return "[]";
                });
    }

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchProducts();
        CompletableFuture<String> reviewsFuture = fetchReviews();
        CompletableFuture<String> inventoryFuture = fetchInventory();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenAcceptAsync(result -> {
            try {
                String products = productsFuture.get();
                String reviews = reviewsFuture.get();
                String inventory = inventoryFuture.get();

                // Further processing of the fetched data
                System.out.println("Products: " + products);
                System.out.println("Reviews: " + reviews);
                System.out.println("Inventory: " + inventory);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, executor);

        allFutures.join();
        executor.shutdown();
    }
}
