package com.richard.multithreading.m8_future;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ApiIntegration {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<String> getProductInformation() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.bestbuy.com/v1/products?format=json&apiKey=YOUR_API_KEY"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    public static CompletableFuture<String> getInventory() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://world.openfoodfacts.org/api/v0/product/{barcode}.json"))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
