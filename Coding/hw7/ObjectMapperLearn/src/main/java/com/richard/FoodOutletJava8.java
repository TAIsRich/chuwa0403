package com.richard;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

public class FoodOutletJava8 {

    public static void main(String[] args) throws IOException {
        List<String> seattle = getRelevantFoodOutlets("Seattle", 140);
        System.out.println(seattle);
    }

    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException {

        String URL_BASE = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_ADDR = URL_BASE + "&page=1";

        // Handle Page 1
        String resBody = callUrl(URL_ADDR);
        List<String> res = new ArrayList<>(processData(resBody, maxCost));

        // Get total pages
        JsonObject jsonBody = new JsonParser().parse(resBody).getAsJsonObject();
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());

        // Handle the 2nd page to the last page
        for (int i = 2; i <= total_pages; i++) {
            URL_ADDR = URL_BASE + "&page=" + i;
            resBody = callUrl(URL_ADDR);
            res.addAll(processData(resBody, maxCost));
        }

        return res;
    }

    private static String callUrl(String URL_ADDR) throws IOException {
        URL url = new URL(URL_ADDR);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        return br.readLine();
    }

    private static List<String> processData(String resBody, int maxCost) {
        List<String> res = new ArrayList<>();

        JsonObject jsonObject = new JsonParser().parse(resBody).getAsJsonObject();

        JsonArray jsonArray = jsonObject.get("data").getAsJsonArray();
        jsonArray.forEach(d -> {
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if (estimated_cost <= maxCost) {
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });

        return res;
    }
}
