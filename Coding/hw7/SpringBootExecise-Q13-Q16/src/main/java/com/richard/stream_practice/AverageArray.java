package com.richard.stream_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

public class AverageArray {

    public static void main(String[] args) {
        int[] arr = new int[] {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        System.out.println(getAverage(arr));
    }

    public static double getAverage(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }
}
