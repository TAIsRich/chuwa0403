package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodOutletsGson {
    private static Gson gson = new Gson();
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        List<String> seattle = FoodOutletJackson.getRelevantFoodOutlets11("Seattle", 140);
        System.out.println(seattle);

    }
    public static List<String> getRelevantFoodOutlets11(String city, int maxCost) throws IOException {
        List<String> res = new ArrayList<>();
        String BASE_URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city;
        String URL_Addr = BASE_URL + "&page=1";

        //处理page1
        String resBody = callURL(URL_Addr);
        //获得所有cost <= maxCost 的name;
        List<String> strings = processData(resBody,maxCost);
        res.addAll(strings);
        //获取所有页面
        FoodOutletJackson.FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);

        int total_pages =foodOutlet.getTotal_pages();

        //处理剩余page :2-lastpage
        for(int i = 2; i <= total_pages;i++){
            URL_Addr = BASE_URL + "&page=" + i;
            resBody = callURL(URL_Addr);
            strings = processData(resBody, maxCost);
            res.addAll(strings);
        }
        return res;

    }
    private static String callURL(String url_adrr) throws IOException {
        URL url = new URL(url_adrr);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = br.readLine();
        return line;


    }
    private static List<String > processData(String resBody, int maxCost) throws JsonProcessingException {
        FoodOutletJackson.FoodOutlet foodOutlet = gson.fromJson(resBody, FoodOutlet.class);
        List<FoodOutletJackson.Data> datas = foodOutlet.getData();
        List<String> collect = datas.stream().filter(data->data.getEstimated_cost()<= maxCost).map(data->data.getName()).collect(Collectors.toList());
        return collect;

    }
    static class FoodOutlet{
        int page;
        int per_page;
        int total;
        int total_pages;
        List<FoodOutletJackson.Data> data;

        public int getTotal_pages() {
            return total_pages;
        }

        public List<FoodOutletJackson.Data> getData() {
            return data;
        }
    }
    static class Data{
        String city;
        String name;
        int estimated_cost;
        FoodOutletJackson.UserRating user_rating;
        int id;

        public String getName() {
            return name;
        }

        public int getEstimated_cost() {
            return estimated_cost;
        }
    }
    static class UserRating{

        float average_rating;
        int votes;
    }

}
