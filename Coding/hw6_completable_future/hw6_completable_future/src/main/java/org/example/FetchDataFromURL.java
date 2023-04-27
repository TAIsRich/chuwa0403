package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class FetchDataFromURL {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String urlComment = "https://jsonplaceholder.typicode.com/comments/1";
        String urlPosts = "https://jsonplaceholder.typicode.com/posts/1";
        CompletableFuture<JSONObject> future = fetchData(httpClient, url);
        CompletableFuture<JSONObject> futureComment = fetchData(httpClient, urlComment);
        CompletableFuture<JSONObject> futurePosts = fetchData(httpClient, urlPosts);


        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future, futureComment, futurePosts);

        allFutures.thenRun(() -> {
            try {
                JSONObject mergedJson = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(future.get());
                jsonArray.put(futureComment.get());
                jsonArray.put(futurePosts.get());
                mergedJson.put("data", jsonArray);
                System.out.println(mergedJson.toString(4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<JSONObject> fetchData(HttpClient httpClient, String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(request,
                HttpResponse.BodyHandlers.ofString());

        CompletableFuture<JSONObject> futureResult = futureResponse.thenApply(response -> {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(response.body());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return jsonObject;
        });

        return futureResult;
    }
}
