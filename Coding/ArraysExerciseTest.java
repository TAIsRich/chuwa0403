package com.chuwa.exercise.collection;

import org.junit.Test;

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
        // create an array of integers
        int[] numbers = new int[5];

        // insert elements into the array
        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 5;
        numbers[3] = 7;
        numbers[4] = 9;

        // retrieve an element from the array
        int thirdNumber = numbers[2];
        System.out.println("Third number is: " + thirdNumber);

        // iterate over the array and print its elements
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element " + i + " is: " + numbers[i]);
        }
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
        // create an array of integers
        int[] numbers = { 9, 1, 5, 3, 7 };

        // sort the array using the Arrays class
        Arrays.sort(numbers);

        // search for an element in the array using the binarySearch() method
        int index = Arrays.binarySearch(numbers, 5);

        // print the sorted array and the index of the searched element
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Index of searched element: " + index);

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
        // create an array of integers
        int[] numbers = { 1, 2, 3, 4, 5 };

        // create a new array and copy the elements of the original array to it
        int[] copy = Arrays.copyOf(numbers, numbers.length);

        // print the original and the copied arrays
        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Copied array: " + Arrays.toString(copy));

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
        String[] colors = { "Red", "Green", "Blue" };
        List<String> colorList = Arrays.asList(colors);
        System.out.println(colorList);//[Red, Green, Blue]

        int[] numbers1 = { 1, 2, 3 };
        int[] numbers2 = { 1, 2, 3 };
        boolean result = Arrays.equals(numbers1, numbers2);
        System.out.println(result); // true

        int[] numbers = { 1, 2, 3, 4, 5 };
        Arrays.fill(numbers, 0);
        System.out.println(Arrays.toString(numbers)); // [0, 0, 0, 0, 0]

    }
}
