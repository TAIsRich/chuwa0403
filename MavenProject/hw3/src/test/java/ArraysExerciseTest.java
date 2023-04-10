import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
        assertEquals(1, numbers[0]);
        numbers[1] = 4;
        assertEquals(4, numbers[1]);
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
        int[] numbers = { 1, 5, 2, 4, 6, 0};
        assertEquals(3, Arrays.binarySearch(numbers, 4));
        Arrays.sort(numbers, 0,4); //[1, 2, 4, 5, 6, 0]
        assertEquals(2, numbers[1]);
        Arrays.sort(numbers);
        assertEquals(0, numbers[0]);
        Arrays.parallelSort(numbers); //opposite case applies for a descending order series
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
        int[] copyAll = Arrays.copyOf(numbers, numbers.length);
        assertEquals(10, copyAll[9]);

        int[] copyRange = Arrays.copyOfRange(numbers, 1, 5);
        System.out.println(Arrays.toString(copyRange));
        assertEquals(2, copyRange[0]);
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
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        assertEquals(1, list.get(0).intValue());

        int[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        assertTrue(Arrays.equals(numbers1, numbers2));

        int[] numbers3 = new int[10];
        Arrays.fill(numbers3, 5);

        for(int num : numbers3){
            assertEquals(5, num);
        }
    }
}
