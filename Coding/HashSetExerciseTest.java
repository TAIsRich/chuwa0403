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
        // Creating a new HashSet
        HashSet<String> mySet = new HashSet<>();

        // Adding elements to the HashSet
        mySet.add("John");
        mySet.add("Mary");
        mySet.add("Bob");

        // Printing out the size of the HashSet
        System.out.println("Size of HashSet: " + mySet.size());

        // Checking if an element is in the HashSet
        boolean containsJohn = mySet.contains("John");
        boolean containsJane = mySet.contains("Jane");

        // Printing out the results of the contains() method
        System.out.println("Contains John? " + containsJohn);
        System.out.println("Contains Jane? " + containsJane);

        // Removing an element from the HashSet
        mySet.remove("Bob");

        // Printing out the updated HashSet
        System.out.println("Updated HashSet: " + mySet);

    }
}
