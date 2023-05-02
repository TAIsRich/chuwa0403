package com.richard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 * Requirements:
 *  1, Java 11 或 以上 -> call api
 *  2, Gson: import com.google.gson.*;
 *      not selected: JackSon:
 *      import com.fasterxml.jackson.databind.ObjectMapper;
 *      -> objectMapper.readValue(s, FoodOutlets.class) food
 *      -> food.getEstimatedCost() <= maxCost -> food.getName;
 *  3, if "estimated_cost" < maxCost  -> "name"
 *
 *  gson.fromJson(string, target.class);
 */

public class FoodOutletJackson {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = getRelevantFoodOutlets("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException, URISyntaxException, InterruptedException {

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_ADDR = BASE_URL + "&page=1";

        // Handle page1
        String resBody = callUrl(URL_ADDR);
        List<String> str = processData(resBody, maxCost);
        List<String> res = new ArrayList<>(str);

        // Get total pages
        FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
        int total_pages = foodOutlet.getTotal_pages();
        // Print the object we get from the first page
        String s = objectMapper.writeValueAsString(foodOutlet);
        System.out.println(s);

        // Handle the 2nd page to last page
        for (int i = 2; i <= total_pages; i++) {
            URL_ADDR = BASE_URL + "&page=" + i;
            resBody = callUrl(URL_ADDR);
            str = processData(resBody, maxCost);
            res.addAll(str);
        }

        return res;
    }

    private static String callUrl(String url) throws IOException, URISyntaxException, InterruptedException {
        // define an HttpClient
        HttpClient httpClient = HttpClient.newBuilder().build();
        // define an HttpRequest
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置 header
                .header(
                        "User-Agent",
                        "Java HttpClient"
                )
                .header(
                        "Accept",
                        "*/*"
                )
                // 设置超时
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();

        // User HttpClient to send this HttpRequest
        HttpResponse<String> response = httpClient
                .send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        // Http 允许重复的 Header, 所以一个 Header 可对应多个 Value
        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }

        // Check Status code
        if (response.statusCode() != 200) {
            throw new RuntimeException("Bad Response!");
        }

        // Only return response body
        return response.body();
    }

    private static List<String> processData(String resBody, int maxCost) throws JsonProcessingException {
        FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);

        List<Data> infos = foodOutlet.getData();

        return infos.stream()
                .filter(data -> data.getEstimatedCost() <= maxCost)
                .map(Data::getName)
                .collect(Collectors.toList());
    }

    static class FoodOutlet {
        @JsonProperty("page")
        int page;

        @JsonProperty("per_page")
        int per_page;

        @JsonProperty("total")
        int total;

        @JsonProperty("total_pages")
        int total_pages;

        @JsonProperty("data")
        List<Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<Data> getData() {
            return data;
        }
    }

    static class Data {
        @JsonProperty("city")
        String city;

        @JsonProperty("name")
        String name;

        @JsonProperty("estimated_cost")
        int estimates_cost;

        @JsonProperty("id")
        int id;

        public String getName() {
            return name;
        }

        public int getEstimatedCost() {
            return estimates_cost;
        }
    }

    static class UserRating {
        @JsonProperty("average_rating")
        float average_rating;

        @JsonProperty("votes")
        int votes;
    }
}
