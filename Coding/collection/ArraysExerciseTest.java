
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create an integer array with initial values
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Retrieve the value at index 3
        int valueAtIndex3 = numbers[3];
        System.out.println("Value at index 3: " + valueAtIndex3); // Output: Value at index 3: 4

        // Set the value at index 6 to 42
        numbers[6] = 42;

        // Retrieve the value at index 6 again to confirm that it has changed
        int valueAtIndex6 = numbers[6];
        System.out.println("Value at index 6: " + valueAtIndex6); // Output: Value at index 6: 42
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = {10, 5, 8, 3, 6, 2, 7, 9, 4, 1};

        // binary search
        int index = Arrays.binarySearch(numbers, 6);
        System.out.println("Index of 6: " + index);

        // sort a part
        Arrays.sort(numbers, 3, 7);
        System.out.println("Sorted part of array: " + Arrays.toString(numbers));

        // sort
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // parallel sort
        int[] parallelNumbers = {10, 5, 8, 3, 6, 2, 7, 9, 4, 1};
        Arrays.parallelSort(parallelNumbers);
        System.out.println("Parallel sorted array: " + Arrays.toString(parallelNumbers));
    }


    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] originalArray = {1, 2, 3, 4, 5};

        // Copy the entire original array
        int[] copiedArray1 = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println(Arrays.toString(copiedArray1)); // [1, 2, 3, 4, 5]

        // Copy the first 3 elements of the original array
        int[] copiedArray2 = Arrays.copyOfRange(originalArray, 0, 3);
        System.out.println(Arrays.toString(copiedArray2)); // [1, 2, 3]
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
        // asList()
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        // equals()
        Integer[] numbers1 = {1, 2, 3, 4, 5};
        Integer[] numbers2 = {1, 2, 3, 4, 5};
        boolean areEqual = Arrays.equals(numbers1, numbers2);
        System.out.println("Are arrays equal? " + areEqual);

        // fill()
        int[] numbers3 = new int[5];
        Arrays.fill(numbers3, 20);
        System.out.println(Arrays.toString(numbers3));
    }
}
