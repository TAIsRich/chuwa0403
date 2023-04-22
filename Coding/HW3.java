package Coding;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HW3 {
    private static final Logger LOGGER = Logger.getLogger(HW3.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchProducts();
        CompletableFuture<String> reviewsFuture = fetchReviews();
        CompletableFuture<String> inventoryFuture = fetchInventory();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            String productsData = productsFuture.join();
            String reviewsData = reviewsFuture.join();
            String inventoryData = inventoryFuture.join();


            System.out.println("Products Data: " + productsData);
            System.out.println("Reviews Data: " + reviewsData);
            System.out.println("Inventory Data: " + inventoryData);
        });

    }

    public static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String productsData = "https://jsonplaceholder.typicode.com/products";
                return productsData;
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception occurred while fetching products data", e);
                return "default products data";
            }
        });
    }

    public static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                
                String reviewsData = "https://jsonplaceholder.typicode.com/reviews";
                return reviewsData;
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception occurred while fetching reviews data", e);
                return "default reviews data";
            }
        });
    }

    public static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                
                String inventoryData = "inventory";
                return inventoryData;
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception occurred while fetching inventory data", e);
                return "default inventory data";
            }
        });
    }
}