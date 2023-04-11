package hw3.collections;

import org.junit.Test;

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
    LinkedList<Integer> tmp = null;
    @Test
    public void learn_Inserting_And_Retrieving() {
        tmp = new LinkedList<>();
        tmp.add(1);
        tmp.addFirst(0);
        tmp.add(2,2);
        LinkedList<Integer> another = tmp;
        tmp = new LinkedList<>();
        tmp.add(3);
        tmp.add(4);
        tmp.addAll(0, another);
        System.out.println(tmp);

        System.out.println(tmp.getFirst() == 0);
        System.out.println(tmp.getLast() == 4);
        System.out.println(tmp.get(2) == 2);
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
        tmp = new LinkedList<>();
        tmp.add(1);
        tmp.addFirst(0);
        tmp.add(2,2);
        tmp.add(3);
        tmp.add(4);
        tmp.removeFirst();
        System.out.println(tmp);
        tmp.removeLast();
        System.out.println(tmp);
        tmp.remove(0);
        System.out.println(tmp);
        tmp.remove(new Integer(3));
        System.out.println(tmp);
        tmp.add(4);
        tmp.removeFirstOccurrence(4);
        System.out.println(tmp);

        tmp.add(100);
        Collections.sort(tmp, Collections.reverseOrder());
    }
}
