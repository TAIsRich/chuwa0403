import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q25C {
    private static final Logger LOGGER = Logger.getLogger(Q25C.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchProducts();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error fetching products: " + e.getMessage(), e);
                return "{ \"products\": [] }"; // Return default value in case of error
            }
        });

        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchReviews();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error fetching reviews: " + e.getMessage(), e);
                return "{ \"reviews\": [] }"; // Return default value in case of error
            }
        });

        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchInventory();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error fetching inventory: " + e.getMessage(), e);
                return "{ \"inventory\": [] }"; // Return default value in case of error
            }
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);
        allFutures.thenRun(() -> {
            String productsJson = productsFuture.join();
            String reviewsJson = reviewsFuture.join();
            String inventoryJson = inventoryFuture.join();

            // Merge the fetched data for further processing
            System.out.println("Fetched Products: " + productsJson);
            System.out.println("Fetched Reviews: " + reviewsJson);
            System.out.println("Fetched Inventory: " + inventoryJson);
        });
    }

    public static String fetchProducts() throws Exception {
        // Make an HTTP GET request to the products API and fetch the data
        // Throw an exception to simulate an error
        throw new Exception("Unable to fetch products.");
    }

    public static String fetchReviews() throws Exception {
        // Make an HTTP GET request to the reviews API and fetch the data
        String reviewsJson = "{ \"reviews\": [ { \"productId\": 1, \"review\": \"Good product.\" }, { \"productId\": 2, \"review\": \"Bad product.\" } ] }";
        return reviewsJson;
    }

    public static String fetchInventory() throws Exception {
        // Make an HTTP GET request to the inventory API and fetch the data
        String inventoryJson = "{ \"inventory\": [ { \"productId\": 1, \"quantity\": 10 }, { \"productId\": 2, \"quantity\": 5 } ] }";
        return inventoryJson;
    }
}
