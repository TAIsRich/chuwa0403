package com.richard.multithreading.m7_executor_framework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhuhaotian
 * @Date 2023/4/20
 */

public class WebCrawlerExample {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList(
                "https://chuwa.com",
                "https://chuwa.org",
                "https://chuwa.net"
        );

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            es.submit(() -> {
                try {
                    downloadAndSave(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void downloadAndSave(String urlString) throws IOException {
        URL url = new URL(urlString);
        String fileName = "output_" + url.getHost() + ".html";

        try (Scanner scanner = new Scanner(url.openStream());
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine());
                writer.newLine();
            }
            System.out.println("Downloaded and saved: " + fileName);
        }
    }
}
