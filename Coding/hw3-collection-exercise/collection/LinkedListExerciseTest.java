package com.chuwa.exercise.collection;

import org.junit.Test;

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
        LinkedList<String> list = new LinkedList<>();

        // Add elements to the LinkedList
        list.add("apple");
        list.add("banana");
        list.add("orange");

        // Retrieve the first element in the LinkedList
        String firstElement = list.getFirst();
        System.out.println("First element: " + firstElement);

        // Retrieve the last element in the LinkedList
        String lastElement = list.getLast();
        System.out.println("Last element: " + lastElement);

        // Retrieve an element by its index
        String secondElement = list.get(1);
        System.out.println("Second element: " + secondElement);
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
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements to the LinkedList
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(3);

        // Remove the first element in the LinkedList
        int firstElement = list.removeFirst();
        System.out.println("Removed first element: " + firstElement);

        // Remove the last element in the LinkedList
        int lastElement = list.removeLast();
        System.out.println("Removed last element: " + lastElement);

        // Sort the LinkedList in ascending order
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
    }
}
