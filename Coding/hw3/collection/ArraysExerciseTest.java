package com.chuwa.exercise.collection;

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
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    @Test
    public void learn_Inserting_And_Retrieving() {
        numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
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
        Arrays.binarySearch(numbers, 4);
        Arrays.sort(numbers);
        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers));
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
        Arrays.copyOf(numbers, numbers.length);

        Arrays.copyOfRange(numbers, 0, 5);
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
        System.out.println();
        Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(num);
        int[] numbers1 = numbers;
        int[] numbers2 = numbers;
        Arrays.equals(numbers1, numbers2);
        Arrays.fill(numbers, 20);

    }
}
