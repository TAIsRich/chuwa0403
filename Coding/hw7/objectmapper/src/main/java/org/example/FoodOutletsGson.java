package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

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
import java.util.stream.Collectors;

public class FoodOutletsGson {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = FoodOutletJackson.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException, URISyntaxException, InterruptedException {
        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        // 处理page 1
        String resBody = callURL(URL_Addr);
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        // get total_pages
        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);

        int total_pages = foodOutlet.getTotal_pages();

        // 处理剩余page: 2 - last page
        for (int i = 2; i <= total_pages; i++) {
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }

        return res;
    }

    private static List<String> processData(String resBody, int maxCost) throws JsonProcessingException {
        FoodOutletJackson.FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutletJackson.FoodOutlet.class);
        List<FoodOutletJackson.Data> datas = foodOutlet.getData();
        List<String> collect = datas.stream().filter(data -> data.getEstimated_cost() <= maxCost).map(data -> data.getName()).collect(Collectors.toList());
        return collect;
    }

    private static String callURL(String url) throws IOException, InterruptedException, URISyntaxException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2).build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException("bad response");
        }

        // only return response body
        return response.body();

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
        List<FoodOutletJackson.Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<FoodOutletJackson.Data> getData() {
            return data;
        }
    }

    static class Data {
        @JsonProperty("city")
        String city;

        @JsonProperty("name")
        String name;

        @JsonProperty("estimated_cost")
        int estimated_cost;

        @JsonProperty("user_rating")
        FoodOutletJackson.UserRating user_rating;

        @JsonProperty("id")
        int id;

        public String getName() {
            return name;
        }

        public int getEstimated_cost() {
            return estimated_cost;
        }
    }

    static class UserRating {
        @JsonProperty("average_rating")
        float average_rating;

        @JsonProperty("votes")
        int votes;
    }
}
