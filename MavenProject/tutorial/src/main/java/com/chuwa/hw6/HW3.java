package com.chuwa.hw6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HW3 {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        CompletableFuture<JsonNode> postsFuture = fetchJson("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<JsonNode> commentsFuture = fetchJson("https://jsonplaceholder.typicode.com/comments");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(postsFuture, commentsFuture).thenRun(
                () -> {
                    try {
                        JsonNode posts = postsFuture.get().get(0);
                        JsonNode comments = commentsFuture.get().get(0);

                        System.out.println(posts);
                        System.out.println(comments);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        );

        combinedFuture.join();
    }

    private static CompletableFuture<JsonNode> fetchJson(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApplyAsync(body -> {
                    try {
                        return objectMapper.readTree(body);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }
}
