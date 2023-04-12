package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Min He
 * @date 4/9/23 21:09 PM
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
        for(int i = 0; i < numbers.length;i++){
            System.out.print(numbers[i] + " ");
        }
        numbers[0] = -1;
        System.out.println(numbers[0]);
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
        int[] numbers = { 2, 1, 3, 4, 5, 7, 10, 8, 9, 6 };
        System.out.println(Arrays.toString(numbers));

        /**Arrays.binarySearch(numbers, 4)**/
        int num =  Arrays.binarySearch(numbers,4);
        System.out.println(num);

        /**sort(array)**/
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        /**sort(array, fromIndex, toIndex)**/
        numbers = new int[]{2, 1, 3, 5, 4, 10, 7, 8, 9, 6};
        Arrays.sort(numbers,1,6);
        System.out.println(Arrays.toString(numbers));

        /**Arrays.parallelSort(numbers);**/
        numbers = new int[]{2, 1, 3, 5, 4, 10, 7, 8, 9, 6};
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
        int[] numbers = { 2, 1, 3, 4, 5, 7, 10, 8, 9, 6 };

        /**Arrays.copyOf(numbers, numbers.length)**/
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println(Arrays.toString(copy));

        /**Arrays.copyOfRange(numbers, 0, 5)**/
        int[] copy1 = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println(Arrays.toString(copy1));
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
        Integer[] numbers = { 2, 1, 3, 4, 5, 7, 10, 8, 9, 6 };

        /**asList()**/
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        /**equals()**/
        Integer[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        boolean check = Arrays.equals(numbers1, numbers);
        System.out.println(check);

        /**fill()**/
        int[] number = new int[5];
        Arrays.fill(number,10);
        System.out.println(Arrays.toString(number));
    }
}
