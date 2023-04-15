package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        // Creating a new TreeSet
        TreeSet<String> mySet = new TreeSet<>();

        // Inserting values into the TreeSet
        mySet.add("John");
        mySet.add("Mary");
        mySet.add("Bob");

        // Retrieving a value from the TreeSet
        String firstElement = mySet.first();
        System.out.println("First element in TreeSet is: " + firstElement);

        // Removing a value from the TreeSet
        mySet.remove("Mary");

        // Printing out the TreeSet
        System.out.println("TreeSet: " + mySet);
    }
}
