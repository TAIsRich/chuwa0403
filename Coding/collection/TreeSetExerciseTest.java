package Coding.collection;

import org.junit.Test;

import java.util.*;

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
        TreeSet<Integer> set= new TreeSet<>();
        set.add(5);
        set.add(4);
        set.add(1);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        set.addAll(list);

        System.out.println("set.contains(1) = " + set.contains(1));

        System.out.println("set.first() =" + set.first());
        System.out.println("set.last() = " + set.last());

        Set<Integer> newSet = set.subSet(2, 5);
        for (int num : newSet)
            System.out.println("num = " + num);

        set.remove((Integer)5);
        set.clear();
        System.out.println("set.size() = " + set.size());
    }
}
