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
        // Creating a new LinkedList
        LinkedList<String> myList = new LinkedList<>();

        // Inserting values into the LinkedList
        myList.add("John");
        myList.add("Mary");
        myList.add("Bob");

        // Retrieving a value from the LinkedList
        String firstElement = myList.getFirst();
        System.out.println("First element: " + firstElement);

        // Printing out the LinkedList
        System.out.println("LinkedList: " + myList);
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
        // Creating a new LinkedList
        LinkedList<String> myList = new LinkedList<>();

        // Inserting values into the LinkedList
        myList.add("John");
        myList.add("Mary");
        myList.add("Bob");

        // Removing a value from the LinkedList
        myList.remove("Mary");

        // Sorting the LinkedList
        Collections.sort(myList);

        // Printing out the updated LinkedList
        System.out.println("Updated LinkedList: " + myList);
    }
}
