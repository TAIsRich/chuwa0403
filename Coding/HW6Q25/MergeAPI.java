package mutithreads.mergeAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeAPI {
    private static final Logger logger = Logger.getLogger(MergeAPI.class.getName());

    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String productsUrl = "https://example.com/products";
        String reviewsUrl = "https://example.com/reviews";
        String inventoryUrl = "https://example.com/inventory";

        CompletableFuture<List<String>> productsFuture = fetchData(httpClient, productsUrl, "default products");
        CompletableFuture<List<String>> reviewsFuture = fetchData(httpClient, reviewsUrl, "default reviews");
        CompletableFuture<List<String>> inventoryFuture = fetchData(httpClient, inventoryUrl, "default inventory");

        CompletableFuture<List<String>> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture)
                .thenApply(v -> {
                    List<String> allData = new ArrayList<>();
                    try {
                        allData.addAll(productsFuture.get());
                        allData.addAll(reviewsFuture.get());
                        allData.addAll(inventoryFuture.get());
                    } catch (InterruptedException | ExecutionException e) {
                        logger.log(Level.SEVERE, "Exception while fetching data", e);
                    }
                    return allData;
                });

        try {
            List<String> mergedData = allFutures.get();
            // further processing of merged data can go here
            System.out.println("Merged data: " + mergedData);
        } catch (InterruptedException | ExecutionException e) {
            logger.log(Level.SEVERE, "Exception while processing merged data", e);
        }
    }

    private static CompletableFuture<List<String>> fetchData(HttpClient httpClient, String url, String defaultValue) {
        return CompletableFuture.supplyAsync(() -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    return processData(response.body());
                } else {
                    logger.log(Level.SEVERE, "Invalid status code received from API {0}: {1}", new Object[]{url, response.statusCode()});
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception while fetching data from API " + url, e);
            }
            // return default value on exception
            return List.of(defaultValue);
        });
    }

    private static List<String> processData(String data) {
        // Process the data from the API
        return List.of(data);
    }
}


