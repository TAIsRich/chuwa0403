package multithread.completable;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HW2HW3 {
    public static void main(String[] args) {
        CompletableFuture<String> products = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("products");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> reviews = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("reviews");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> inventory = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchData("inventory");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> allFetches = CompletableFuture.allOf(products, reviews, inventory);

        allFetches.thenRun(() -> {
            String productsData = products.join();
            String reviewsData = reviews.join();
            String inventoryData = inventory.join();

            // Merge the fetched data and process it further
            String mergedData = mergeData(productsData, reviewsData, inventoryData);
            System.out.println("Merged data: " + mergedData);
            // M    
        });
    }

    private static String fetchData(String apiName) throws IOException {
        String apiUrl = "https://jsonplaceholder.typicode.com/" + apiName;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("Failed to get data from " + apiName);
            } else {
                Scanner scanner = new Scanner(url.openStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String mergeData(String productsData, String reviewsData, String inventoryData) {
        // Merge the fetched data and return the result
        return productsData + " - " + reviewsData + " - " + inventoryData;
    }
}
