package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> l = new CopyOnWriteArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);

        l.add(2, 6);

        List<Integer> nList = new ArrayList<>();
        nList.add(4);
        nList.add(5);
        l.addAll(nList);

        ((CopyOnWriteArrayList<Integer>) l).addIfAbsent(4);
        ((CopyOnWriteArrayList<Integer>) l).addIfAbsent(8);

        List<Integer> yetAnotherList = new ArrayList<>();
        yetAnotherList.add(12);
        yetAnotherList.add(7);
        ((CopyOnWriteArrayList<Integer>) l).addAllAbsent(yetAnotherList);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> it = list.iterator();
    }
}
