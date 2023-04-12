import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        list.add(1);
        list.addLast(2);
        list.addFirst(0);
        list.add(3,3);  //0 1 2 3
        List<Integer> listAdd = new LinkedList<Integer>();
        listAdd.add(4);
        list.addAll(listAdd);

        //System.out.println(list); //0 1 2 3 4

        list.addAll(5,listAdd);
        //System.out.println(list);

        list.getFirst();

        assertEquals(4, list.getLast().intValue());
        assertEquals(4, list.get(4).intValue());

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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.removeLastOccurrence(10);

        //System.out.println(list.toString()); //2 4 5

        Collections.sort(list);

    }
}
