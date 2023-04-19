import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Retrieve element at index 2
        assertEquals(3, numbers[2]);

        // Change value at index 5 to 42
        numbers[5] = 42;
        assertEquals(42, numbers[5]);
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

        int[] numbers = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        // sort array
        Arrays.sort(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, numbers);

        // binary search, should sort first
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println(index);
        assertEquals(3, index);

        // sort array from index 2 to 6
        int[] numbers2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        Arrays.sort(numbers2, 2, 6);
        assertArrayEquals(new int[]{10, 9, 5, 6, 7, 8, 4, 3, 2, 1}, numbers2);

        // parallel sort array
        int[] numbers3 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        Arrays.parallelSort(numbers3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, numbers3);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] copyOfNumbers = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy of numbers: " + Arrays.toString(copyOfNumbers));

        int[] copyOfRangeNumbers = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println("Copy of range of numbers: " + Arrays.toString(copyOfRangeNumbers));

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
        System.out.println("List: " + list);

        // equals()
        Integer[] numbers1 = {1, 2, 3};
        Integer[] numbers2 = {1, 2, 3};
        boolean equalArrays = Arrays.equals(numbers1, numbers2);
        System.out.println("Are the arrays equal? " + equalArrays);

        // fill()
        Integer[] numbersToFill = new Integer[5];
        Arrays.fill(numbersToFill, 10);
        System.out.println("Filled array: " + Arrays.toString(numbersToFill));
    }
}
