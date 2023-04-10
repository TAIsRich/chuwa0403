package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
    LinkedList<Integer> list;
    @Test
    public void learn_Inserting_And_Retrieving() {
        list = new LinkedList<>();
        list.add(1);
        list.addFirst(0);
        list.addLast(2);

        List<Integer> list2 = new LinkedList<Integer>() {{
            add(3);
            add(4);
            add(5);
        }};

        list.addAll(list2);

        assertEquals(0, list.getFirst());
        assertEquals(5, list.getLast());
        assertEquals(1, list.get(1));
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
        list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(0);

        list.removeFirst();
        list.removeLast();
        list.remove(1);


        list.add(1);// 1, 1
        list.add(3);// 1, 1, 3
        list.add(4);// 1, 1, 3, 4
        list.add(3);// 1, 1, 3, 4 ,3

        list.removeLastOccurrence(3);

        assertEquals(1, list.getFirst());
        assertEquals(1, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(4, list.size());

        list.add(2);
        Collections.sort(list);
        assertEquals(2, list.get(2));


    }
}
