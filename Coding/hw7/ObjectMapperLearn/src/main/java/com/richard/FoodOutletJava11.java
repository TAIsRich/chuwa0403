package com.richard;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

public class FoodOutletJava11 {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = getRelevantFoodOutlets("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException, URISyntaxException, InterruptedException {
        String URL_BASE = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_ADDR = URL_BASE + "&page=1";

        // Handle page 1
        String resBody = callURL(URL_ADDR);
        List<String> res = new ArrayList<>(processData(resBody, maxCost));

        // Get the total pages
        JsonObject jsonObject = (JsonObject) JsonParser.parseString(resBody);
        int totalPages = jsonObject.get("total_pages").getAsInt();

        for (int i = 2; i <= totalPages; i++) {
            URL_ADDR = URL_BASE + "&page=" + i;
            resBody = callURL(URL_ADDR);
            res.addAll(processData(resBody, maxCost));
        }

        return res;
    }

    public static String callURL(String url) throws URISyntaxException, IOException, InterruptedException {
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

    private static List<String> processData(String resBody, int maxCost) {
        List<String> res = new ArrayList<>();

        JsonObject jsonBody = (JsonObject) JsonParser.parseString(resBody);
        jsonBody.get("data").getAsJsonArray().forEach(d -> {
            int estimatedCost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if (estimatedCost <= maxCost)
                res.add(d.getAsJsonObject().get("name").getAsString());
        });

        return res;
    }
}
