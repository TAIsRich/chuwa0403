import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ArraysExerciseTest {
    Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        numbers[0] = -1;
        assertEquals(-1, numbers[0].intValue());
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
        assertEquals(3, Arrays.binarySearch(numbers, 4));
        Arrays.sort( numbers, 0, numbers.length);
        Arrays.parallelSort(numbers);
        Arrays.sort(numbers, Comparator.reverseOrder());
        assertEquals(10, numbers[0].intValue());
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
        Integer[] arr = Arrays.copyOf(numbers, 3);
        Integer[] arr2 = Arrays.copyOfRange(numbers, 0, 4);
        assertEquals(3, arr.length);
        assertEquals(4, arr2.length);
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
        List<Integer> list = Arrays.asList(numbers);
        Integer[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertTrue(Arrays.equals(numbers2, numbers));
        Arrays.fill(numbers, 20);
    }
}