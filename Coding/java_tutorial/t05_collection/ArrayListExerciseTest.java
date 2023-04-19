import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;

import static org.junit.Assert.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new ArrayList
        List<Integer> list = new ArrayList<>();

        // Test adding elements
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        // Test getting elements
        System.out.println(list.get(0));
        System.out.println(list.get(2));

        // Test getting size
        assertEquals(3, list.size());

        // Test adding another list
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list.addAll(list2);
        System.out.println(list);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Create a new ArrayList
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Test removing an element by index
        list.remove(0);
        assertEquals(4, list.size());
        System.out.println(list);

        // Test removing an element by object
        list.remove(Integer.valueOf(2));
        assertEquals(3, list.size());
        System.out.println(list);

        // Test removing a range of elements
        list.subList(0, 2).clear();
        assertEquals(1, list.size());
        System.out.println(list);

        // Test removing all elements in a collection
        list.addAll(Arrays.asList(5, 6, 7));
        Collection<Integer> toRemove = Arrays.asList(5, 6);
        list.removeAll(toRemove);
        System.out.println(list);

        // Test clearing the list
        list.clear();
        System.out.println(list);

        // Test setting an element at an index
        list.addAll(Arrays.asList(1, 2, 3));
        list.set(1, 4);
        System.out.println(list);

        // Test replacing all elements using UnaryOperator
        UnaryOperator<Integer> operator = num -> num + 1;
        list.replaceAll(operator);
        System.out.println(list);

        // Test checking if a list contains an element
        assertTrue(list.contains(5));
        assertFalse(list.contains(6));

        // Test getting the index of an element
        assertEquals(1, list.indexOf(5));

        // Test getting the last index of an element
        assertEquals(1, list.lastIndexOf(5));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        // create an ArrayList with some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // create an Iterator for the ArrayList
        Iterator<String> iterator = list.iterator();

        // iterate over the ArrayList using the Iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // remove the current element from the ArrayList
            iterator.remove();
        }

        // check that the ArrayList is now empty
        assertTrue(list.isEmpty());
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // create an ArrayList with some elements
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);

        // sort the ArrayList using the sort() method of the Collections class
        Collections.sort(list);

        // check that the elements are now sorted in ascending order
        assertEquals(2, (int) list.get(0));
        assertEquals(5, (int) list.get(1));
        assertEquals(8, (int) list.get(2));

        // sort the ArrayList in reverse order using the sort() method and reverseOrder() Comparator
        Collections.sort(list, Comparator.reverseOrder());

        // check that the elements are now sorted in descending order
        assertEquals(8, (int) list.get(0));
        assertEquals(5, (int) list.get(1));
        assertEquals(2, (int) list.get(2));
    }
}
