import org.junit.Test;

import java.util.ArrayList;
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
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new LinkedList<Integer>();

        // Inserting
        list.add(1); // adds 1 to the end of the list
        System.out.println(list);

        ((LinkedList<Integer>) list).addLast(2); // adds 2 to the end of the list
        System.out.println(list);

        ((LinkedList<Integer>) list).addFirst(0); // adds 0 to the beginning of the list
        System.out.println(list);

        list.add(1, 5); // adds 5 at index 1
        System.out.println(list);

        List<Integer> sublist = new ArrayList<>();
        sublist.add(3);
        sublist.add(4);
        list.addAll(sublist); // adds all elements from sublist to the end of the list
        list.addAll(2, sublist); // adds all elements from sublist starting at index 2
        System.out.println(list);

        // Retrieving
        int first = ((LinkedList<Integer>) list).getFirst(); // returns the first element (0)
        System.out.println(first);
        int last = ((LinkedList<Integer>) list).getLast(); // returns the last element (4)
        System.out.println(last);
        int third = list.get(2); // returns the element at index 2 (3)
        System.out.println(third);
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
        List<String> list = new LinkedList<>();

        // inserting
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("grape");
        list.add("kiwi");
        System.out.println(list);

        // removing
        ((LinkedList<String>) list).removeFirst();
        System.out.println(list);
        ((LinkedList<String>) list).removeLast();
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        list.remove("banana");
        System.out.println(list);

        ((LinkedList<String>) list).removeLastOccurrence("kiwi");
        System.out.println(list);

        list.add("kiwi");
        list.add("banana");
        list.add("grape");
        // sorting
        Collections.sort(list);
        System.out.println(list);
    }
}
