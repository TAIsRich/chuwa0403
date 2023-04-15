package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        List<Integer> list = Arrays.asList(5, 4, 6);
        set.addAll(list);
        boolean contains = set.contains(4);
        System.out.println("Set contains 4: " + contains);
        int first = ((TreeSet<Integer>) set).first();
        int last = ((TreeSet<Integer>) set).last();
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);
        Set<Integer> subset = ((TreeSet<Integer>) set).subSet(1, 3);
        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(2);
        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(2);
        int size = set.size();
        boolean isEmpty = set.isEmpty();
        set.remove(2);


    }
}
