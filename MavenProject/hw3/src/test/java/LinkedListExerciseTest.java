import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
     * <p>
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     */
    LinkedList<Integer> list = new LinkedList<>();
    @Before
    public void before() {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void learn_Inserting_And_Retrieving() {
        list.addFirst(0);
        assertEquals(0, list.get(0).intValue());

        list.addLast(4);
        assertEquals(4, list.get(4).intValue());

        list.add(5, 5);
        assertEquals(5, list.get(5).intValue());

        List<Integer> another = new LinkedList<>();
        another.add(6);
        another.add(7);

        list.addAll(another);
        assertEquals(8, list.size());

        assertEquals(0, list.getFirst().intValue());
        assertEquals(7, list.getLast().intValue());
        assertEquals(1, list.get(1).intValue());

    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     * <p>
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        list.removeFirst();
        assertEquals(2, list.get(0).intValue());

        list.removeLast();
        assertEquals(2, list.get(0).intValue());

        list.remove(0);
        assertTrue(list.isEmpty());

        list.add(1);
        list.add(5);
        list.add(3);
        list.sort(Comparator.naturalOrder());
        assertEquals(5, list.get(list.size() - 1).intValue());
    }
}