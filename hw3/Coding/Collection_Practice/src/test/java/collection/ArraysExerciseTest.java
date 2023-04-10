package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
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
    int[] numbers = {1, 2, 3, 9, 8, 7, 6};
    @Test
    public void learn_Inserting_And_Retrieving() {
        assertEquals(1, numbers[0]);
        numbers[0] = 5;
        assertEquals(5, numbers[0]);
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
        int[] temp = {1, 2, 3, 6, 7, 8, 9};
        assertEquals(Arrays.binarySearch(numbers, 9), 3);
        Arrays.sort(numbers);
        assertArrayEquals(numbers, temp);
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
        assertArrayEquals(numbers, Arrays.copyOf(numbers, numbers.length));
        assertArrayEquals(Arrays.copyOfRange(numbers, 0, 3), Arrays.copyOf(numbers, 3));
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
        List<Integer> list = Arrays.asList(1, 2, 3, 9, 8, 7, 6);
        assertEquals(numbers[0], list.get(0));

        assumeTrue(list.get(0).equals(numbers[0]));
        Arrays.fill(numbers, 0);
        assumeTrue(numbers[0] == 0);

    }
}
