package org.example;


import netscape.javascript.JSObject;
import com.google.gson.*;
import java.net.*;
import java.net.URI;
import java.net.http.HttpClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FootOutletsJava11 {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = FootOutletsJava11.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);
    }


    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException, URISyntaxException, InterruptedException {
        List<String> res = new ArrayList<>();

        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;

        String URL_Addr = BASE_URL + "&page=1";

        String resBody = callUrl(URL_Addr);
        List<String> strings = processData(resBody, maxCost);
        res.addAll(strings);

        JsonObject jsonBody = (JsonObject) JsonParser.parseString(resBody);
        int total_pages = Integer.parseInt(jsonBody.get("total_pages").getAsString());
        for (int i = 2; i <= total_pages; i++) {
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callUrl(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }

        return res;
    }

    private static String callUrl(String url) throws IOException, InterruptedException, URISyntaxException {
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

    public static List<String> processData(String resBody, int maxCost) {

        List<String> res = new ArrayList<>();

        JsonObject jsonBody = (JsonObject) JsonParser.parseString(resBody);

        JsonArray jsonArray = jsonBody.get("data").getAsJsonArray();
        jsonArray.forEach(d ->{
            int estimated_cost = d.getAsJsonObject().get("estimated_cost").getAsInt();
            if (estimated_cost <= maxCost) {
                res.add(d.getAsJsonObject().get("name").getAsString());
            }
        });
        return res;
    }
}
