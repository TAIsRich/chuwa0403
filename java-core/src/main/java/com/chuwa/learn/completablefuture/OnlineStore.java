package com.chuwa.learn.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStore {
    private static final Logger logger = Logger.getLogger(OnlineStore.class.getName());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchFromAPI("https://jsonplaceholder.typicode.com/products"));
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchFromAPI("https://jsonplaceholder.typicode.com/reviews"));
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchFromAPI("https://jsonplaceholder.typicode.com/inventory"));

        CompletableFuture<String> mergedData = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenApplyAsync((Void) -> {
                    String products = productsFuture.join();
                    String reviews = reviewsFuture.join();
                    String inventory = inventoryFuture.join();
                    return mergeData(products, reviews, inventory);
                })
                .exceptionally(e -> {
                    logger.log(Level.SEVERE, "Error occurred during API call: " + e.getMessage());
                    return "Default Value";
                });

        String finalData = mergedData.get();
        System.out.println("Final Data: \n" + finalData);
    }

    private static String fetchFromAPI(String url) {
        try {
            // Simulate API call
            Thread.sleep(1000);
            return "API data from " + url;
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Error occurred during API call: " + e.getMessage());
            return "Default Value";
        }
    }

    private static String mergeData(String products, String reviews, String inventory) {
        // Merge the fetched data
        return products + "\n" + reviews + "\n" + inventory;
    }
}

