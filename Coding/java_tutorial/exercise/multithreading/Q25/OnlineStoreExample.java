package multithreading.Q25;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class OnlineStoreExample {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/products");
        CompletableFuture<String> reviewsFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/reviews");
        CompletableFuture<String> inventoryFuture = fetchDataFromApi("https://jsonplaceholder.typicode.com/inventory");

        // Merge the fetched data from three APIs
        CompletableFuture<String> mergedDataFuture = productsFuture
                .thenCombine(reviewsFuture, (products, reviews) -> products + ", " + reviews)
                .thenCombine(inventoryFuture, (mergedData, inventory) -> mergedData + ", " + inventory);

        try {
            String mergedData = mergedDataFuture.get();
            System.out.println("Merged data: " + mergedData);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            // Fetch data from API
            // For demonstration purpose, returning a static string
            return "Data from " + apiUrl;
        });
    }
}