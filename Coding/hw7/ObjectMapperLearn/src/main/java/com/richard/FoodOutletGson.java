package com.richard;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

public class FoodOutletGson {

    private static final Gson gson = new Gson();

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        List<String> seattle = getRelevantFoodOutlets("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws URISyntaxException, IOException, InterruptedException {
        String URL_BASE = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_ADDR = URL_BASE + "&page=1";

        // Handle page 1
        String resBody = callURL(URL_ADDR);
        List<String> res = new ArrayList<>(processData(resBody, maxCost));

        // Get total pages
        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);
        int totalPages = foodOutlet.getTotal_pages();

        // Handle the rest of the pages
        for (int i = 2; i <= totalPages; i++) {
            URL_ADDR = URL_BASE + "&page=" + i;
            resBody = callURL(URL_ADDR);
            res.addAll(processData(resBody, maxCost));
        }

        return res;
    }

    private static String callURL(String url) throws URISyntaxException, IOException, InterruptedException {
        // Create HttpClient
        HttpClient httpClient = HttpClient.newBuilder().build();
        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置header
                .header(
                        "User-Agent",
                        "Java HttpClient"
                )
                .header(
                        "Accept",
                        "*/*"
                )
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();

        // Use HttpClient to sent HttpRequest
        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        // Check status code
        if (response.statusCode() != 200) throw new RuntimeException("Bad Response!");

        // Only return the response body
        return response.body();
    }

    private static List<String> processData(String resBody, int maxCost) {

        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);
        List<Data> data = foodOutlet.getData();

        return data.stream()
                .filter(d -> d.getEstimated_cost() <= maxCost)
                .map(Data::getName)
                .collect(Collectors.toList());
    }

    static class FoodOutlet {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<Data> getData() {
            return data;
        }
    }

    static class Data {
        String city;
        String name;
        int estimated_cost;
        UserRating user_rating;
        int id;


        public String getName() {
            return name;
        }

        public int getEstimated_cost() {
            return estimated_cost;
        }
    }

    static class UserRating {
        float average_rating;
        int votes;
    }
}
