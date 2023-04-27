package com.chuwa.learn.hw6;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class hw3 {

    private static final Logger LOGGER = Logger.getLogger(hw2.class.getName());

    public static void main(String[] args) {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // Call the products API
                String productsJson = callApi("https://jsonplaceholder.typicode.com/products");
                return productsJson;
            } catch (Exception e) {
                // Log the exception and return a default value
                LOGGER.log(Level.SEVERE, "Error calling products API: " + e.getMessage());
                return "";
            }
        });

        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // Call the reviews API
                String reviewsJson = callApi("https://jsonplaceholder.typicode.com/reviews");
                return reviewsJson;
            } catch (Exception e) {
                // Log the exception and return a default value
                LOGGER.log(Level.SEVERE, "Error calling reviews API: " + e.getMessage());
                return "";
            }
        });

        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // Call the inventory API
                String inventoryJson = callApi("https://jsonplaceholder.typicode.com/inventory");
                return inventoryJson;
            } catch (Exception e) {
                // Log the exception and return a default value
                LOGGER.log(Level.SEVERE, "Error calling inventory API: " + e.getMessage());
                return "";
            }
        });

        CompletableFuture<Void> mergedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        mergedFuture.thenRun(() -> {
            try {
                // Get the results of the API calls and merge them
                String productsJson = productsFuture.get();
                String reviewsJson = reviewsFuture.get();
                String inventoryJson = inventoryFuture.get();
                String mergedJson = mergeData(productsJson, reviewsJson, inventoryJson);

                // Process the merged data
                processMergedData(mergedJson);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error processing merged data: " + e.getMessage());
            }
        });

        // Wait for the merged future to complete
        try {
            mergedFuture.get();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error waiting for merged future to complete: " + e.getMessage());
        }
    }

    private static String callApi(String apiUrl) throws Exception {
        // Simulate calling an API by sleeping for a random amount of time
        Thread.sleep((long) (Math.random() * 1000));

        // Simulate an exception being thrown for some calls
        if (Math.random() < 0.2) {
            throw new Exception("API call failed");
        }

        // Return some dummy data
        return "{ \"data\": [] }";
    }

    private static String mergeData(String productsJson, String reviewsJson, String inventoryJson) {
        // Merge the data from the APIs
        return "{ \"mergedData\": [] }";
    }

    private static void processMergedData(String mergedJson) {
        // Process the merged data
        System.out.println("Merged data: " + mergedJson);
    }

}


