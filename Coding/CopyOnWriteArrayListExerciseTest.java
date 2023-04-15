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
        // Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();

        // Add some names to the list
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");


    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> names = new CopyOnWriteArrayList<>();
        names.add("Apple");
        names.add("Banana");
        names.add("Orange");

        //Created an iterator
        Iterator<String> it = names.iterator();
        // Print the contents of the list using the iterator
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Add a new name to the list
        names.add("shit");

        // Print the contents of the list again using the same iterator
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
