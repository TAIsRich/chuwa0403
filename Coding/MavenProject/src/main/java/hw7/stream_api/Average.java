package hw7.stream_api;

import java.util.Arrays;
import java.util.stream.Stream;

public class Average {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{20, 3, 78, 9, 6, 53, 73, 99, 2};
        Stream<Integer> stream = Arrays.stream(arr);
        double avg = (double) stream.reduce(Integer::sum).orElseThrow(() -> new NullPointerException()) / arr.length;
        System.out.println(avg);
    }
}
