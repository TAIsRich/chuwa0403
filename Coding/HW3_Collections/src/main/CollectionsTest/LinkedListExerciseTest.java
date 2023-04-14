package CollectionsTest;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class LinkedListExerciseTest {
    LinkedList<Integer> list = new LinkedList<Integer>();

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

        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(100000);
        list.addLast(22);
        list.addFirst(0);
        list.add(2, 4);
        list.addAll(list2);
        list.addAll(2, list2);

        //get
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));
        System.out.println(list);

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
        //remove
        list.add(100);
        list.add(69);
        list.add(23);
        list.add(2);
        list.add(120);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        list.remove(2);
        list.remove((Object) 2);
        list.removeLastOccurrence(2);
        System.out.println(list);

        //sort
        list.add(101);
        list.add(102);

        list.sort(null);
        System.out.println(list);


    }
}
