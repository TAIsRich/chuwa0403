import java.util.Arrays;

public class StreamAverageExample {
    public static void main(String[] args) {
        int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

        // Get the average of the array using the Stream API
        double average = Arrays.stream(numbers)
                .average()
                .orElse(Double.NaN);

        // Print the average
        System.out.println("Average: " + average);
    }
}
