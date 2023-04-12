package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Min He
 * @date 4/9/23 10:56 AM
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
        TreeSet<Integer> set1= new TreeSet<>();
        TreeSet<Integer> set2= new TreeSet<>();

        /** add(E e)**/
        set1.add(2);
        set1.add(1);
        set1.add(3);
        set2.add(4);
        set2.add(1);
        set2.add(5);
        System.out.println(set1);
        System.out.println(set2);

        /** addAll(Collection<> c)**/
        set1.addAll(set2);
        System.out.println(set1);

        /** contains(Object o)**/
        boolean con = set1.contains(3);
        System.out.println(con);

        /** first()&last()**/
        int first = set1.first();
        int last = set1.last();
        System.out.println(first);
        System.out.println(last);

        /** subSet(E fromElement, E toElement)*/
        TreeSet set3 = (TreeSet)set1.subSet(1,4);
        System.out.println(set3);

        /** headSet(E toElement)**/
        TreeSet set4 = (TreeSet)set1.headSet(3);
        System.out.println(set4);

        /** tailSet(E fromElement)**/
        TreeSet set5 = (TreeSet)set1.tailSet(3);
        System.out.println(set5);

        /** remove(Object o)**/
        set1.remove(3);
        System.out.println(set1);

        /** size()&isEmpty()**/
        System.out.println(set1.size());
        System.out.println(set1.isEmpty());

    }
}
