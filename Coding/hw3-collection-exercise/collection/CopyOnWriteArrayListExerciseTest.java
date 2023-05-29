package com.chuwa.exercise.collection;

import org.junit.Test;

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
        CopyOnWriteArrayList<Integer> myList = new CopyOnWriteArrayList<>();

        // Adding elements to the thread-safe ArrayList
        myList.add(5);
        myList.add(3);
        myList.add(8);
        myList.add(1);
        myList.add(2,2);
        myList.addIfAbsent(2);
        myList.addAllAbsent(myList);

        // Iterating over the thread-safe ArrayList
        for (Integer i : myList) {
            System.out.println(i);
        }
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
        Iterator<String> itr = list.iterator();
        while (it.hasNext()) {
            String element = it.next();
            System.out.println(element);
            if (element.equals("Banana")) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}
