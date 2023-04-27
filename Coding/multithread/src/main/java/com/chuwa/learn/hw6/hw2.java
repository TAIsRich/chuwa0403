package com.chuwa.learn.hw6;

import java.util.concurrent.CompletableFuture;

public class hw2 {

        public static void main(String[] args) {
            CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> {
                return fetchData("https://jsonplaceholder.typicode.com/products");
            });

            CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> {
                return fetchData("https://jsonplaceholder.typicode.com/reviews");
            });

            CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> {
                return fetchData("https://jsonplaceholder.typicode.com/inventory");
            });

            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

            combinedFuture.thenRun(() -> {
                try {
                    String productsData = productsFuture.get();
                    String reviewsData = reviewsFuture.get();
                    String inventoryData = inventoryFuture.get();

                    // Merge the fetched data for further processing
                    String mergedData = mergeData(productsData, reviewsData, inventoryData);
                    System.out.println("Merged Data: " + mergedData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        private static String fetchData(String url) {
            // Code to fetch data from the given URL
            return null;
        }

        private static String mergeData(String productsData, String reviewsData, String inventoryData) {
            // Code to merge the fetched data
            return null;
        }
}
