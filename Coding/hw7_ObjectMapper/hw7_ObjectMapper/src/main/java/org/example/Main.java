package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int[] arr = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double ans = (Arrays.stream(arr).average().orElse(Double.NaN));
        System.out.println(ans);
    }
}