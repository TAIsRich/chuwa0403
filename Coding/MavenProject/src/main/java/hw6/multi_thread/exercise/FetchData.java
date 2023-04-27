package hw6.multi_thread.exercise;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FetchData {
    public static void main(String[] args) {
        CompletableFuture<String> posts = getRequest("https://jsonplaceholder.typicode.com/posts");
        CompletableFuture<String> users = getRequest("https://jsonplaceholder.typicode.com/users");

        CompletableFuture<Void> cf = CompletableFuture.allOf(posts, users).thenRun(()->{
            try{
                System.out.println(posts.get());
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
            try {
                System.out.println(users.get());
            }catch (InterruptedException| ExecutionException e){
                e.printStackTrace();
            }
        });
    }

    public static CompletableFuture<String> getRequest(String uri){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        return client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        // for exception handling:
        /*
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
         */
    }
}
