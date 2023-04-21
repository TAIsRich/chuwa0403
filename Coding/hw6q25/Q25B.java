import java.util.concurrent.CompletableFuture;

public class Q25B {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchProducts());
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchReviews());
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchInventory());

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

    public static String fetchProducts() {
        // Make an HTTP GET request to the products API and fetch the data
        String productsJson = "{ \"products\": [ { \"id\": 1, \"name\": \"Product 1\" }, { \"id\": 2, \"name\": \"Product 2\" } ] }";
        return productsJson;
    }

    public static String fetchReviews() {
        // Make an HTTP GET request to the reviews API and fetch the data
        String reviewsJson = "{ \"reviews\": [ { \"productId\": 1, \"review\": \"Good product.\" }, { \"productId\": 2, \"review\": \"Bad product.\" } ] }";
        return reviewsJson;
    }

    public static String fetchInventory() {
        // Make an HTTP GET request to the inventory API and fetch the data
        String inventoryJson = "{ \"inventory\": [ { \"productId\": 1, \"quantity\": 10 }, { \"productId\": 2, \"quantity\": 5 } ] }";
        return inventoryJson;
    }
}
