package Coding;

import java.util.concurrent.CompletableFuture;
public class HW2 {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = fetchProducts();
        CompletableFuture<String> reviewsFuture = fetchReviews();
        CompletableFuture<String> inventoryFuture = fetchInventory();
        
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);
        
        allFutures.thenRun(() -> {
            String productsData = productsFuture.join();
            String reviewsData = reviewsFuture.join();
            String inventoryData = inventoryFuture.join();
            
            // merge data
            System.out.println("Products Data: " + productsData);
            System.out.println("Reviews Data: " + reviewsData);
            System.out.println("Inventory Data: " + inventoryData);
        });
        
    }
    
    public static CompletableFuture<String> fetchProducts() {
        return CompletableFuture.supplyAsync(() -> {
            // fetch products data from API
            String productsData = "https://jsonplaceholder.typicode.com/products";
            return productsData;
        });
    }
    
    public static CompletableFuture<String> fetchReviews() {
        return CompletableFuture.supplyAsync(() -> {
            // fetch reviews data from API
            String reviewsData = "https://jsonplaceholder.typicode.com/reviews";
            return reviewsData;
        });
    }
    
    public static CompletableFuture<String> fetchInventory() {
        return CompletableFuture.supplyAsync(() -> {
            // fetch inventory data from API
            String inventoryData = "https://jsonplaceholder.typicode.com/inventory";
            return inventoryData;
        });
    }
}