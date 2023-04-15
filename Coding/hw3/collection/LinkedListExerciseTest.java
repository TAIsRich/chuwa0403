package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ((LinkedList<Integer>) list).addFirst(0);
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(4);
        newList.add(5);
        list.addAll(newList);
        list.add(3, 100);
        ((LinkedList<Integer>) list).addLast(200);

        assertEquals(0, list.get(0).intValue());
        assertEquals(1, list.get(1).intValue());
        assertEquals(2, list.get(2).intValue());
        assertEquals(10, list.get(3).intValue());
        assertEquals(0, ((LinkedList<Integer>) list).getFirst().intValue());
        assertEquals(20, ((LinkedList<Integer>) list).getLast().intValue());
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);


        list.remove(3);
        ((LinkedList<Integer>) list).removeFirst();
        ((LinkedList<Integer>) list).removeLast();
        list.remove((Object) 2);
        ((LinkedList<Integer>) list).removeLastOccurrence(1);
        Collections.sort(list);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
    }
}
