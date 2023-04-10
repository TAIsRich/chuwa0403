package Coding.Collection;
import java.util.*;


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
    LinkedList<Integer> list = new LinkedList<>();
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(0);
        list.add(1);
        list.addLast(2);
        list.addFirst(3);
        list.add(0, 1);
        list.addAll(list1);

        list.getFirst();
        list.getLast();
        list.get(0);
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

    
    public void learn_Remove_Sort() {
        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.remove(new Integer(1));
        list.removeLastOccurrence(new Integer(1));
    }
}

