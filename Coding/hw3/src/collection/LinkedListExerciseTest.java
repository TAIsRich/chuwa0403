package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Min He
 * @date 4/9/23 1:18 AM
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
         LinkedList<Integer> list = new LinkedList<Integer>();

         /** add(E e) or addLast(E e)**/
         list.add(1);
         list.add(2);
         list.add(3);
         System.out.println(list);
         list.addLast(4);
        System.out.println(list);

        /** addFirst(E e)**/
         list.addFirst(0);
        System.out.println(list);

        /** add(int index, E element)**/
        list.add(1,-1);
        System.out.println(list);

        /** addAll(Collection c)**/
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.addAll(list);
        System.out.println(list2);

        /** addAll(int index, Collection c)**/
        list2.addAll(4,list);
        System.out.println(list2);

        /** getFirst()**/
        int num = list.getFirst();
        System.out.println(num);

        /** getLast()**/
        int num2 = list.getLast();
        System.out.println(num2);

        /** get(int index)**/
        int num3 = list.get(1);
        System.out.println(num3);

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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(-1);
        list.add(8);
        list.add(0);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(4);
        list.add(2);
        System.out.println(list);

        /** removeFirst()**/
        list.removeFirst();
        System.out.println(list);

        /** removeLast() **/
        list.removeLast();
        System.out.println(list);

        /**remove(int index)**/
        list.remove(2);
        System.out.println(list);

        /** remove(Object o)**/
        list.remove(Integer.valueOf(9));
        System.out.println(list);

        /** removeLastOccurrence()**/
        list.removeLastOccurrence(4);
        System.out.println(list);

        /** sort() **/
        Collections.sort(list);
        System.out.println(list);
    }
}
