import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
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
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);

        list.addFirst(2); // 2 0 1
        assertTrue(list.getFirst() == 2);

        LinkedList<Integer> anotherList = new LinkedList<>();
        anotherList.add(3);
        anotherList.add(4);
        list.addAll(anotherList); // 2 0 1 3 4
        assertTrue(list.get(3) == 3);

        list.addAll(1, anotherList); // 2 0 1 3 4 4
        assertTrue(list.getLast() == 4);
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
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4); // 0 1 2 3 4

        list.removeFirst(); // 1 2 3 4
        assertTrue(list.getFirst() == 1);

        list.removeLast(); // 1 2 3
        assertTrue(list.getLast() == 3);

        list.remove(1); // 1 3
        assertTrue(list.get(1) == 3);

        list.remove((Integer)3); // 1
        assertTrue(list.size() == 1);

        list.add(2);
        list.add(0);
        list.add(1); // 1 2 0 1
        list.removeLastOccurrence((Integer)1); // 1 2 0
        assertTrue(list.get(list.size() - 1) == 0);

        list.sort(Comparator.comparingInt(o -> o)); // 0 1 2
        assertTrue(list.get(0) == 0);
    }
}
