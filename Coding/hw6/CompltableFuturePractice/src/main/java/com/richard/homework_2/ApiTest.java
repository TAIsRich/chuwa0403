package com.richard.homework_2;

import java.util.concurrent.CompletableFuture;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ApiTest {
    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(ApiTest::fetchProducts);
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(ApiTest::fetchReviews);
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(ApiTest::fetchInventory);

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
        String productsJson = "Fake Data: { \"products\": [ { \"id\": 1, \"name\": \"Product 1\" }, { \"id\": 2, \"name\": \"Product 2\" } ] }";
        return productsJson;
    }

    public static String fetchReviews() {
        // Make an HTTP GET request to the reviews API and fetch the data
        String reviewsJson = "Fake Data: { \"reviews\": [ { \"productId\": 1, \"review\": \"Good product.\" }, { \"productId\": 2, \"review\": \"Bad product.\" } ] }";
        return reviewsJson;
    }

    public static String fetchInventory() {
        // Make an HTTP GET request to the inventory API and fetch the data
        String inventoryJson = "Fake Data: { \"inventory\": [ { \"productId\": 1, \"quantity\": 10 }, { \"productId\": 2, \"quantity\": 5 } ] }";
        return inventoryJson;
    }
}

