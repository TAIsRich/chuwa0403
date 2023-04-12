
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
        // Create a new linked list
        List<Integer> list = new LinkedList<Integer>();

        // Use add method to insert elements at the end of the list
        list.add(1);
        list.add(2);
        list.add(3);

        // Use addFirst method to insert an element at the beginning of the list
        ((LinkedList<Integer>) list).addFirst(0);

        // Use addAll method to insert a collection of elements at the end of the list
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(4);
        newList.add(5);
        list.addAll(newList);

        // Use add method to insert an element at a specific index in the list
        list.add(3, 100);

        // Use addLast method as an alternative to add method to insert an element at the end of the list
        ((LinkedList<Integer>) list).addLast(200);

        // Use get method to retrieve an element at a specific index in the list
        assertEquals(0, list.get(0).intValue());
        assertEquals(1, list.get(1).intValue());
        assertEquals(2, list.get(2).intValue());
        assertEquals(100, list.get(3).intValue());
        assertEquals(3, list.get(4).intValue());
        assertEquals(4, list.get(5).intValue());
        assertEquals(5, list.get(6).intValue());
        assertEquals(200, list.get(7).intValue());

        // Use getFirst and getLast methods to retrieve the first and last elements in the list
        assertEquals(0, ((LinkedList<Integer>) list).getFirst().intValue());
        assertEquals(200, ((LinkedList<Integer>) list).getLast().intValue());
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
        // Create a new linked list
        List<Integer> list = new LinkedList<Integer>();

        // Use add method to insert elements at the end of the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Use remove method to remove an element at a specific index in the list
        list.remove(3);

        // Use removeFirst method to remove the first element in the list
        ((LinkedList<Integer>) list).removeFirst();

        // Use removeLast method to remove the last element in the list
        ((LinkedList<Integer>) list).removeLast();

        // Use remove method to remove the first occurrence of an element in the list
        list.remove((Object) 2);

        // Use removeLastOccurrence method to remove the last occurrence of an element in the list
        ((LinkedList<Integer>) list).removeLastOccurrence(1);

        // Use sort method to sort the elements in the list
        Collections.sort(list);

        // Check that the list contains the expected elements
        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(3, list.get(1).intValue());
        assertEquals(4, list.get(2).intValue());
    }
}
