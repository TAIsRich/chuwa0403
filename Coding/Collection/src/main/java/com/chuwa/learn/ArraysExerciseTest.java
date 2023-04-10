package com.chuwa.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
       int[] numbers = {1,2,3,4,5};
       System.out.println(numbers[0]);
       numbers[0] = 100;
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
        int[] nums = {100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int n : nums){
            System.out.println(n);
        }

        System.out.println(Arrays.binarySearch(nums, 10));
        Arrays.sort(nums);
        Arrays.sort(nums, 0,2);
        Arrays.parallelSort(nums);
        for(int n : nums){
            System.out.println(n);
        }
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
        int[] nums = {1,2,3,4,5};
        int[] arr = Arrays.copyOf(nums,nums.length);
        for(int n : arr){
            System.out.println(n);
        }
        arr = Arrays.copyOfRange(nums, 0, 3);
        for(int n : arr){
            System.out.println(n);
        }
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
        Integer[] nums = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(nums);
        System.out.println(list);

        Integer[] nums1 = {1,2,3,4,5};
        System.out.println(Arrays.equals(nums,nums1));
        Arrays.fill(nums1,10);
        System.out.println(Arrays.equals(nums,nums1));

    }
}
