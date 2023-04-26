package avgArray;

import java.util.Arrays;

public class AvgArray {
    public static double avgArray(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .orElse(Double.NaN);
    }

    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double result = avgArray(numbers);
        System.out.println(result);
    }
}
