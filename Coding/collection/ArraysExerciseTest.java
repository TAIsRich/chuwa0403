package Coding.collection;

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
        System.out.println(numbers[0]);

        numbers[1] = 10;
        System.out.println(numbers[1]);
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
        int[] numbers = new int[] {4, 0, 3, 2, 1};
        Arrays.binarySearch(numbers, 3);

        Arrays.sort(numbers);
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
        int[] numbers = new int[] {4, 0, 3, 2, 1};
        int[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
        int[] copyRangeNumbers = Arrays.copyOfRange(numbers, 0, 3);
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
        String[] letters = new String[] {"a", "b", "c"};
        List<String> list = Arrays.asList(letters);
        System.out.println(letters);


        int[] nums1 = new int[] {4, 0, 3, 2, 1};
        int[] nums2 = new int[] {4, 0, 5, 2, 1};
        System.out.println(Arrays.equals(nums1, nums2));

        int[] nums = new int[5];
        Arrays.fill(nums, 10);
        System.out.println(nums);
    }
}
