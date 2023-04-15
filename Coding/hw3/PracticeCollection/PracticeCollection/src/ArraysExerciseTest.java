import org.junit.Test;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOfRange;

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

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(numbers[0]);
        System.out.println(numbers[0] = 100);

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

        int[] numbers = { 1, 2, 3, 3, 4, 4, 4, 5, 6, 10};
        System.out.println(Arrays.binarySearch(numbers, 4));
        System.out.println(Arrays.binarySearch(numbers, 7));

        int[] numbers2 = {2, 1, 8, 4, 5};
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        int[] numbers3 = {2, 1, 8, 4, 5};
        Arrays.sort(numbers3, 1, 4);
        System.out.println(Arrays.toString(numbers3));

        Arrays.parallelSort(numbers3);
        System.out.println(Arrays.toString(numbers3));

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

        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] x = Arrays.copyOf(nums, 8);
        System.out.println(Arrays.toString(x));

        x = copyOfRange(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(x));

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

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(list);

        int[] nums1 = new int[] {1, 2, 3};
        int[] nums2 = new int[] {1, 2, 3};
        int[] nums3 = new int[] {1};
        System.out.println(nums1.equals(nums2));
        System.out.println(nums1.equals(nums3));

        Arrays.fill(nums1, 50);
        System.out.println(Arrays.toString(nums1));

    }
}
