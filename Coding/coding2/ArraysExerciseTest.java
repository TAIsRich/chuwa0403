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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int specificNumber = numbers[2];

        numbers[5] = 110;


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

        int[] numbers = { 3, 7, 8, 6, 2, 35, 46, 5, 17, 20 };

        int i = Arrays.binarySearch(numbers, 4);

        Arrays.sort(numbers);
        Arrays.parallelSort(numbers, 2, 5);

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

        int[] anotherNumbers = Arrays.copyOf(numbers, numbers.length);

        int[] anotherNumbers1 = Arrays.copyOfRange(numbers, 0, 5);

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

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        List<Integer> list = Arrays.asList(numbers);

        Integer[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, };

        boolean ifEqual = Arrays.equals(numbers, numbers1);

        Arrays.fill(numbers, 999);


    }
}