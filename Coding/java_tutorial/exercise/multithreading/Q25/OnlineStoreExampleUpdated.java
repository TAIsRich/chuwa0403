package multithreading.Q25;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreExampleUpdated {
    private static final Logger LOGGER = Logger.getLogger(OnlineStoreExampleUpdated.class.getName());

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
            LOGGER.log(Level.SEVERE, "Exception occurred during API call: " + e.getMessage(), e);
            // Return default value in case of exception
            String defaultValue = "Default merged data";
            System.out.println("Merged data: " + defaultValue);
        }
    }

    private static CompletableFuture<String> fetchDataFromApi(String apiUrl) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Fetch data from API
                // For demonstration purpose, returning a static string
                return "Data from " + apiUrl;
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception occurred during API call: " + e.getMessage(), e);
                // Return default value in case of exception
                return "Default data from " + apiUrl;
            }
        });
    }
}
