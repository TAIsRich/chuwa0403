package com.chuwa.learn;

import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
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
        Set<Integer> set= new TreeSet<>();
        set.add(1);
        set.add(2);
        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(4);
        set.addAll(set1);
        System.out.println(set);
        System.out.println(set.contains(3));
        System.out.println(((TreeSet<Integer>) set).first());
        System.out.println(((TreeSet<Integer>) set).last());
        System.out.println(((TreeSet<Integer>) set).subSet(1,3));
        System.out.println(((TreeSet<Integer>) set).headSet(3));
        System.out.println(((TreeSet<Integer>) set).tailSet(1));
        set.remove(4);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
