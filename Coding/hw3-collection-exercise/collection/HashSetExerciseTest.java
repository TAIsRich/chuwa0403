package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        HashSet<String> set = new HashSet<>();

        // Adding elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        System.out.println("Initial set: " + set);

        // Checking if an element is present in the set
        System.out.println("Is 'Apple' present in the set? " + set.contains("Apple"));

        // Removing an element from the set
        set.remove("Banana");
        System.out.println("Set after removing 'Banana': " + set);

    }
}
