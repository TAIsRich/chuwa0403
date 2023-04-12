package Coding.Collection;

import java.util.*;

public class ArraysExerciseTest {
    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    
    public void learn_Inserting_And_Retrieving() {
       int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
       numbers[0] = 100;
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
    public void learn_search_and_sort() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.binarySearch(numbers, 4);

        Arrays.sort(numbers);
        Arrays.sort(numbers, 0, 3);
        Arrays.parallelSort(numbers);
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
    
    public void learn_copy_of_array() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] numbers1 = Arrays.copyOf(numbers, numbers.length);
        numbers1[0] = 1;

        numbers1 = Arrays.copyOfRange(numbers, 0, 3);
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

    public void learn_common_operations() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        int[] numbers1 = new int[100];

        Arrays.fill(numbers1, 20);
   

    }
}
