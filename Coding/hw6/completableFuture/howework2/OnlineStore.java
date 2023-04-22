package hw6.completableFuture.howework2;


import java.util.concurrent.CompletableFuture;

public class OnlineStore {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchData("https://jsonplaceholder.typicode.com/posts"));
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchData("https://jsonplaceholder.typicode.com/comments"));
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchData("https://jsonplaceholder.typicode.com/todos"));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            try {
                String productsData = productsFuture.join();
                String reviewsData = reviewsFuture.join();
                String inventoryData = inventoryFuture.join();
                String mergedData = mergeData(productsData, reviewsData, inventoryData);
                System.out.println("Merged data: " + mergedData);
            } catch (Exception e) {
                System.err.println("Error occurred: " + e.getMessage());
            }
        });
    }

    private static String fetchData(String apiUrl) {
        // Perform API call and return response data
        // Here, we are using the JSONPlaceholder API to simulate the calls
        return "N/A";
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Merge the fetched data and perform further processing
        return productsData + reviewsData + inventoryData;
    }
}