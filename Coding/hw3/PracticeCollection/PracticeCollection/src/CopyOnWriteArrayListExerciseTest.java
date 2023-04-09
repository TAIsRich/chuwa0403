import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> ret = new ArrayList<>(Arrays.asList(4, 5, 6));
        ArrayList<Integer> rett = new ArrayList<>(Arrays.asList(6, 7, 8));

        list.add(0);
        System.out.println(list);
        list.add(0, -1);
        System.out.println(list);
        list.addAll(ret);
        System.out.println(list);
        list.addIfAbsent(100);
        System.out.println(list);
        list.addAllAbsent(rett);
        System.out.println(list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();

        // remove() can not be called on the iterator since this is a CopyOnWriteArrayList
        list.remove("Apple");

        System.out.println(list);

    }
}
