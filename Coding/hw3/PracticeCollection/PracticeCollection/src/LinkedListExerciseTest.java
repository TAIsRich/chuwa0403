import org.junit.Test;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

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

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addLast(0);
        list.addFirst(2);
        System.out.println(list);

        list.add(1, -1);
        System.out.println(list);

        List<Integer> x = new ArrayList<>(Arrays.asList(7, 8, 9));
        list.addAll(x);
        System.out.println(list);

        list.addAll(1, x);
        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));

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

        LinkedList<Integer> list = new LinkedList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(-1);
            add(4);
            add(5);
        }};
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.removeLastOccurrence(4);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }
}
