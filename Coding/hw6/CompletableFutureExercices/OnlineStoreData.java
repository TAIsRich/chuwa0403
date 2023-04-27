package Coding.hw6.CompletableFutureExercices;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlineStoreData {
    private final static Logger logger = Logger.getLogger(OnlineStoreData.class.getName());
    private final static String PRODUCTS_URL = "https://jsonplaceholder.typicode.com/products";
    private final static String REVIEWS_URL = "https://jsonplaceholder.typicode.com/reviews";
    private final static String INVENTORY_URL = "https://jsonplaceholder.typicode.com/inventory";


    public static void  main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> productsFuture = CompletableFuture.supplyAsync(() -> fetchDataFromApi(PRODUCTS_URL));
        CompletableFuture<String> reviewsFuture = CompletableFuture.supplyAsync(() -> fetchDataFromApi(REVIEWS_URL));
        CompletableFuture<String> inventoryFuture = CompletableFuture.supplyAsync(() -> fetchDataFromApi(INVENTORY_URL));

        CompletableFuture<String> merged = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenApplyAsync((Void) -> {
                    String products = productsFuture.join();
                    String reviews = reviewsFuture.join();
                    String inventory = inventoryFuture.join();

                    return products + " " + reviews + " " + inventory;
                })
                .exceptionally(e -> {
                    logger.log(Level.WARNING, "Error: " + e.getMessage());
                    return "API called";
                });

        System.out.println(merged.get());
    }

    private static String fetchDataFromApi(String url) {
        try {
            Thread.sleep(1000);
            return "data from " + url;
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Error: " + e.getMessage());
        } finally {
            return "API called";
        }
    }
}
