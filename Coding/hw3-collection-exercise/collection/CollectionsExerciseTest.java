package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        ArrayList<Integer> myList = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add(5);
        myList.add(3);
        myList.add(8);
        myList.add(1);

        // Finding the minimum and maximum values
        int min = Collections.min(myList);
        int max = Collections.max(myList);

        // Printing the results
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> myList = Collections.synchronizedList(new ArrayList<>());

        // Adding elements to the thread-safe ArrayList
        myList.add(5);
        myList.add(3);
        myList.add(8);
        myList.add(1);

        // Iterating over the thread-safe ArrayList
        synchronized (myList) {
            for (Integer i : myList) {
                System.out.println(i);
            }
        }
    }
}
