package com.example.APICall;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodOutletGson {
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        List<String> seattle = FoodOutletJackson.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }

    static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException {
        List<String> res = new ArrayList<>();
        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        // 处理page1
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

    private static String callURL(String URL_Addr) throws IOException {
        URL url = new URL(URL_Addr);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new
                InputStreamReader(con.getInputStream()));
        String line = br.readLine();

        // only return response body
        return line;
    }

    private static List<String> processData(String resBody, int maxCost) throws JsonProcessingException {
        FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);

        List<Data> datas = foodOutlet.getData();

        List<String> collect = datas.stream().filter(data -> data.getEstimated_cost() <= maxCost).map(data -> data.getName()).collect(Collectors.toList());

        return collect;
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
