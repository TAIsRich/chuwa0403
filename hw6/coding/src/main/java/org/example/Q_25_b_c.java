package org.example;

import com.google.gson.JsonElement;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonParser;


public class Q_25_b_c {
    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient();

        CompletableFuture<String> posts = GetData(okHttpClient, "https://jsonplaceholder.typicode.com/postsw");
        CompletableFuture<String> users = GetData(okHttpClient, "https://jsonplaceholder.typicode.com/usersw");

        CompletableFuture completableFuture = CompletableFuture.allOf(posts, users).thenRun(() -> {
            try {
                JsonElement postArray = JsonParser.parseString(posts.get());
                JsonElement usersArray = JsonParser.parseString(users.get());

                System.out.println("Posts: " + (postArray.isJsonArray() ? postArray.getAsJsonArray().get(0) : postArray));
                System.out.println("Users: " + (usersArray.isJsonArray() ? usersArray.getAsJsonArray().get(0) : usersArray));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        completableFuture.join();
    }

    public static CompletableFuture<String> GetData(OkHttpClient client, String url) {
        return CompletableFuture.supplyAsync(() -> {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Error Code" + response);
                }
                return response.body().string();
            } catch (Throwable e) {
                throw new RuntimeException("Error fetching data from " + url, e);
            }
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return "{\"error\": \"Error fetching data from " + url + "\"}";
        });
    }
}
